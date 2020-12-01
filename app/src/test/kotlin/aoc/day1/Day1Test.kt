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
                514579)
        )
    }
}