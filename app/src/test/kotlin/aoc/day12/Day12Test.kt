package aoc.day12

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day12Test {
    @Test
    fun part1() {
        val input = listOf(
            "F10",
            "N3",
            "F7",
            "R90",
            "F11",
        )
        val actual = part1(input)
        Assertions.assertEquals(25, actual)
    }
}