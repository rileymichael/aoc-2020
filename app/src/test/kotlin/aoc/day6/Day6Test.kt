package aoc.day6

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day6Test {

    @Test
    fun part1() {
        val actual = part1(input)
        assertEquals(11, actual)
    }

    @Test
    fun part2() {
        val actual = part2(input)
        assertEquals(6, actual)
    }

    companion object {
        private val input = listOf(
            "abc",
            "",
            "a",
            "b",
            "c",
            "",
            "ab",
            "ac",
            "",
            "a",
            "a",
            "a",
            "a",
            "",
            "b",
        )
    }
}