package aoc.day11

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day11Test {
    @Test
    fun part1() {
        val actual = part1(input)
        Assertions.assertEquals(37, actual)
    }

    @Test
    fun part2() {
        val actual = part2(input)
        Assertions.assertEquals(26, actual)
    }

    companion object {
        private val input = listOf(
            "L.LL.LL.LL",
            "LLLLLLL.LL",
            "L.L.L..L..",
            "LLLL.LL.LL",
            "L.LL.LL.LL",
            "L.LLLLL.LL",
            "..L.L.....",
            "LLLLLLLLLL",
            "L.LLLLLL.L",
            "L.LLLLL.LL",
        )
    }
}