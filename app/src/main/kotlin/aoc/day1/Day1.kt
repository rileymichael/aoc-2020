package aoc.day1

import aoc.Utils

fun main() {
    val report = Utils.readInput(1).map { it.toInt() }

    val part1 = findTargetSum(2020, report)
    println("Part 1: $part1")

    val part2 = part2(2020, report)
    println("Part 2: $part2")
}

fun findTargetSum(target: Int, report: List<Int>): Int? {
    val seen = mutableSetOf<Int>()
    report.forEach { expense ->
        val multiplicand = target - expense

        if (multiplicand in seen) {
            return expense * multiplicand
        }

        seen.add(expense)
    }
    return null
}

fun part2(target: Int, report: List<Int>): Int? {
    report.forEach { expense ->
        val multiplicand = findTargetSum(target - expense, report)
        if (multiplicand != null) {
            return expense * multiplicand
        }
    }
    return null
}
