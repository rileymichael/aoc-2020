package aoc.day2

import aoc.Utils

fun main() {
    val input = Utils.readInput(2)

    val part1 = part1(input)
    println("Part 1: $part1")

    val part2 = part2(input)
    println("Part 2: $part2")
}

fun part1(input: List<String>): Int {
    return input.count { line ->
        val (range, char, password) = line.split(" ")
        val (min, max) = range.split("-").map { it.toInt() }

        listOf<PasswordRule>(
            CharacterFrequency(char.first(), min..max)
        ).all { it.validate(password) }
    }
}

fun part2(input: List<String>): Int {
    return input.count { line ->
        val (range, char, password) = line.split(" ")
        val (min, max) = range.split("-").map { it.toInt() }

        listOf<PasswordRule>(
            CharacterPosition(char.first(), min..max)
        ).all { it.validate(password) }
    }
}

sealed class PasswordRule {
    abstract fun validate(password: String): Boolean
}

data class CharacterFrequency(val char: Char, val range: IntRange) : PasswordRule() {
    override fun validate(password: String): Boolean {
        return password.count { it == char } in range
    }
}

data class CharacterPosition(val char: Char, val range: IntRange) : PasswordRule() {
    override fun validate(password: String): Boolean {
        return (password[range.first - 1] == char) xor (password[range.last - 1] == char)
    }
}
