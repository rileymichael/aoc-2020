package aoc.day2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day2Test {

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
                    "1-3 a: abcde",
                    "1-3 b: cdefg",
                    "2-9 c: ccccccccc",
                ),
                2
            )
        )

        @JvmStatic
        fun part2() = listOf(
            Arguments.of(
                listOf(
                    "1-3 a: abcde",
                    "1-3 b: cdefg",
                    "2-9 c: ccccccccc",
                ),
                1
            )
        )
    }
}