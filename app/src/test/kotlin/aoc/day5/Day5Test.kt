package aoc.day5

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day5Test {

    @ParameterizedTest
    @MethodSource("part1")
    fun part1(input: List<String>, expected: Int) {
        val actual = part1(input)

        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun part1() = listOf(
            Arguments.of(
                listOf(
                    "BFFFBBFRRR",
                    "FFFBBBFRRR",
                    "BBFFBBFRLL"
                ),
                820
            )
        )
    }
}