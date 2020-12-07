package aoc.day3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day3Test {

    @Test
    fun part1() {
        val actual = findTreesInPath(input, Pair(3, 1))
        assertEquals(7, actual)
    }

    @Test
    fun part2() {
        val actual = part2(input)
        assertEquals(336, actual)
    }

    companion object {
        private val input = listOf(
            "..##.......",
            "#...#...#..",
            ".#....#..#.",
            "..#.#...#.#",
            ".#...##..#.",
            "..#.##.....",
            ".#.#.#....#",
            ".#........#",
            "#.##...#...",
            "#...##....#",
            ".#..#...#.#",
        )
    }
}