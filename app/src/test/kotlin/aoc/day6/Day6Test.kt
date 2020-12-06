package aoc.day6

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day6Test {

    @ParameterizedTest
    @MethodSource("part1")
    fun part1(input: List<String>, expected: Int) {
        val actual = part1(input)

        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("part2")
    fun part2(input: List<String>, expected: Int) {
        val actual = part2(input)

        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun part1() = listOf(
            Arguments.of(
                listOf(
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
                ),
                11
            )
        )

        @JvmStatic
        fun part2() = listOf(
            Arguments.of(
                listOf(
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
                ),
                6
            )
        )
    }
}