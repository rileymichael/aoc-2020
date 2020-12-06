package aoc.day6

import aoc.Utils
import aoc.Utils.split

fun main() {
    val input = Utils.readInput(6)

    val part1 = part1(input)
    println("Part 1: $part1")

    val part2 = part2(input)
    println("Part 2: $part2")
}

typealias Group = MutableList<String>
fun Group.answers() = this.map { it.toSet() }

fun part1(input: List<String>): Int {
    val groups = input.split { it.isBlank() } as List<Group>

    return groups.sumBy { group ->
        group.answers().reduce { acc, chars -> acc.union(chars) }.count()
    }
}

fun part2(input: List<String>): Int {
    val groups = input.split { it.isBlank() } as List<Group>

    return groups.sumBy { group ->
        group.answers().reduce { acc, chars -> acc.intersect(chars) }.count()
    }
}