package aoc.day2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day2Test {

    @Test
    fun part1() {
        val actual = part1(input)
        assertEquals(2, actual)
    }

    @Test
    fun part2() {
        val actual = part2(input)
        assertEquals(1, actual)
    }

    companion object {
        private val input = listOf(
            "1-3 a: abcde",
            "1-3 b: cdefg",
            "2-9 c: ccccccccc",
        )
    }
}