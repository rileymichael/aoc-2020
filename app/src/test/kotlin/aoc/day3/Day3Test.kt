package aoc.day3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day3Test {

    @ParameterizedTest
    @MethodSource("part1")
    fun part1(input: List<String>, expected: Long) {
        val actual = findTreesInPath(input, Pair(3, 1))

        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("part2")
    fun part2(input: List<String>, expected: Long) {
        val actual = part2(input)

        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun part1() = listOf(
            Arguments.of(
                listOf(
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
                ),
                7
            )
        )

        @JvmStatic
        fun part2() = listOf(
            Arguments.of(
                listOf(
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
                ),
                336
            )
        )
    }
}