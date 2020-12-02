package aoc.day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day1Test {

    @ParameterizedTest
    @MethodSource("part1")
    fun part1(input: List<Int>, expected: Int) {
        val actual = findTargetSum(2020, input)

        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("part2")
    fun part2(input: List<Int>, expected: Int) {
        val actual = part2(2020, input)

        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun part1() = listOf(
            Arguments.of(
                listOf(
                    1721,
                    979,
                    366,
                    299,
                    675,
                    1456,
                ),
                514579
            ),
            Arguments.of(
                listOf(
                    1010,
                    5,
                    1010,
                    299,
                    675,
                    1456,
                ),
                1020100
            )
        )

        @JvmStatic
        fun part2() = listOf(
            Arguments.of(
                listOf(
                    1721,
                    979,
                    366,
                    299,
                    675,
                    1456,
                ),
                241861950
            )
        )
    }
}