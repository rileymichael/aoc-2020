package aoc.day4

import aoc.Utils
import aoc.Utils.split

fun main() {
    val input = Utils.readInput(4)

    val part1 = part1(input)
    println("Part 1: $part1")

    val part2 = part2(input)
    println("Part 2: $part2")
}

fun part1(input: List<String>): Int {
    return parsePassports(input).count(Passport::hasRequiredFields)
}

fun part2(input: List<String>): Int {
    return parsePassports(input).count(Passport::isValid)
}

fun parsePassports(input: List<String>): List<Passport> {
    val passportsData = input.split { it.isBlank() }

    return passportsData.map { data ->
        val fields = data
            .joinToString(" ")
            .split(" ", ":")
            .chunked(2)
            .map { (field, value) -> field to value }
            .toMap()

        Passport(fields)
    }
}

data class Passport(val fields: Map<String, String>) {
    fun hasRequiredFields(): Boolean {
        return fields.keys.containsAll(REQUIRED_FIELDS)
    }

    fun isValid(): Boolean {
        return hasRequiredFields() && fields.all { isFieldValid(it.key, it.value) }
    }

    private fun isFieldValid(field: String, value: String): Boolean {
        return when (field) {
            BIRTH_YEAR -> value.toIntOrNull() in 1920..2002
            ISSUE_YEAR -> value.toIntOrNull() in 2010..2020
            EXPIRATION_YEAR -> value.toIntOrNull() in 2020..2030
            HEIGHT -> when {
                value.endsWith("cm") -> value.removeSuffix("cm").toIntOrNull() in 150..193
                value.endsWith("in") -> value.removeSuffix("in").toIntOrNull() in 59..76
                else -> false
            }
            HAIR_COLOR -> HAIR_COLOR_REGEX.matches(value)
            EYE_COLOR -> value in EYE_COLORS
            ID -> value.length == 9 && value.toIntOrNull() != null
            COUNTRY_ID -> true
            else -> false
        }
    }

    companion object {
        private val HAIR_COLOR_REGEX = Regex("^#[0-9a-f]{6}$")

        private const val BIRTH_YEAR = "byr"
        private const val ISSUE_YEAR = "iyr"
        private const val EXPIRATION_YEAR = "eyr"
        private const val HEIGHT = "hgt"
        private const val HAIR_COLOR = "hcl"
        private const val EYE_COLOR = "ecl"
        private const val ID = "pid"
        private const val COUNTRY_ID = "cid"

        private val REQUIRED_FIELDS = listOf(
            BIRTH_YEAR,
            ISSUE_YEAR,
            EXPIRATION_YEAR,
            HEIGHT,
            HAIR_COLOR,
            EYE_COLOR,
            ID,
        )

        private val EYE_COLORS = listOf(
            "amb", "blu", "brn", "gry", "grn", "hzl", "oth"
        )
    }
}