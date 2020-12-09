package aoc.day1

import aoc.Utils
import aoc.Utils.twoSum

fun main() {
    val report = Utils.readInput(1).map { it.toInt() }

    val part1 = part1(2020, report)
    println("Part 1: $part1")

    val part2 = part2(2020, report)
    println("Part 2: $part2")
}

fun part1(target: Int, report: List<Int>): Int? {
    val addends = twoSum(target, report)
    if (addends != null)
        return addends.first * addends.second
    return null
}

fun part2(target: Int, report: List<Int>): Int? {
    report.forEach { expense ->
        val multiplicand = part1(target - expense, report)
        if (multiplicand != null) {
            return expense * multiplicand
        }
    }
    return null
}
