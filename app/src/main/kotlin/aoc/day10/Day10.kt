package aoc.day10

import aoc.Utils

fun main() {
    val input = Utils.readInput(10).map { it.toInt() }

    val part1 = part1(input)
    println("Part 1: $part1")
    val part2 = part2(input)
    println("Part 2: $part2")
}

fun part1(input: List<Int>): Int {
    val adapters = input.plus(0).plus(input.maxOrNull()!! + 3).sorted()
    val diffs = adapters.zipWithNext { a, b -> b - a }.groupingBy { it }.eachCount()
    return diffs[1]!! * diffs[3]!!
}

fun part2(input: List<Int>): Long? {
    val perms = mutableMapOf(0 to 1L)
    val adapters = input.sorted()
    adapters.forEach { adapter ->
        perms[adapter] = (1..3).sumOf { perms.getOrDefault(adapter - it, 0) }
    }
    return perms[adapters.maxOrNull()]
}

