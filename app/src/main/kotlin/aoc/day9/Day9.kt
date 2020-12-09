package aoc.day9

import aoc.Utils
import aoc.Utils.twoSum

fun main() {
    val input = Utils.readInput(9).map { it.toLong() }

    val part1 = findInvalid(25, input)
    println("Part 1: $part1")

    val part2 = part2(25, input)
    println("Part 2: $part2")
}

fun part2(preamble: Int, input: List<Long>): Long? {
    val invalid = findInvalid(preamble, input)

    input.filter { it < (invalid / 2 + 1) }.forEachIndexed { idx, value ->
        var sum = value
        var index = idx
        while (sum < invalid) {
            index++
            sum += input[index]
        }

        if (sum == invalid) {
            val set = input.subList(idx, index)
            return set.minOrNull()!! + set.maxOrNull()!!
        }
    }

    return null
}

fun findInvalid(preamble: Int, input: List<Long>): Long {
    var start = 0
    return input.drop(preamble).first {
        val values = input.subList(start, start + preamble)
        val pair = twoSum(it, values)
        start++
        pair == null
    }
}