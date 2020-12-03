package aoc.day3

import aoc.Utils

fun main() {
    val input = Utils.readInput(3)

    val part1 = findTreesInPath(input, Pair(3, 1))
    println("Part 1: $part1")

    val part2 = part2(input)
    println("Part 2: $part2")
}

const val TREE = '#'

fun findTreesInPath(map: List<String>, slope: Pair<Int, Int>): Long {
    var x = 0
    var hits: Long = 0
    val width = map.first().length

    map.filterIndexed { index, _ -> index % slope.second == 0 }.forEach {
        if (it[x] == TREE) {
            hits++
        }
        x = (x + slope.first) % width
    }

    return hits
}

fun part2(input: List<String>): Long {
    val slopes = listOf(
        Pair(1, 1),
        Pair(3, 1),
        Pair(5, 1),
        Pair(7, 1),
        Pair(1, 2)
    )

    return slopes.map { findTreesInPath(input, it) }.reduce { result, treesHit -> result * treesHit }
}