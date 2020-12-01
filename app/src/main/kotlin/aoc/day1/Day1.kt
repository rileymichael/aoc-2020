package aoc.day1

import aoc.Utils

fun main() {
    val report = Utils.readInput(1).map { it.toInt() }

    val part1 = findTargetSum(2020, report)
    println("Part 1: $part1")
}

fun findTargetSum(sum: Int, report: List<Int>): Int? {
    val seen = mutableSetOf<Int>()
    report.forEach { expense ->
        val multiplicand = sum - expense

        if (multiplicand in seen) {
            return expense * multiplicand
        }

        seen.add(expense)
    }
    return null
}

