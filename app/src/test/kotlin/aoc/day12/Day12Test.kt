package aoc.day12

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day12Test {
    @Test
    fun part1() {
        val actual = part1(input)
        Assertions.assertEquals(25, actual)
    }

    @Test
    fun part2() {
        val actual = part2(input)
        Assertions.assertEquals(286, actual)
    }

    companion object {
        private val input = listOf(
            "F10",
            "N3",
            "F7",
            "R90",
            "F11",
        )
    }
}