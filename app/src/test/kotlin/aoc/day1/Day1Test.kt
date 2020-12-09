package aoc.day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day1Test {

    @Test
    fun part1() {
        val actual = part1(2020, input)
        assertEquals(514579, actual)
    }

    @Test
    fun part2() {
        val actual = part2(2020, input)
        assertEquals(241861950, actual)
    }

    companion object {
        private val input = listOf(
            1721,
            979,
            366,
            299,
            675,
            1456,
        )
    }
}