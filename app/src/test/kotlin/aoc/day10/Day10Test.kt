package aoc.day10

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day10Test {

    @ParameterizedTest
    @MethodSource("part1")
    fun part1(input: List<Int>, expected: Int) {
        val actual = part1(input)
        Assertions.assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("part2")
    fun part2(input: List<Int>, expected: Long) {
        val actual = part2(input)
        Assertions.assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun part1() = listOf(
            Arguments.of(
                listOf(
                    16,
                    10,
                    15,
                    5,
                    1,
                    11,
                    7,
                    19,
                    6,
                    12,
                    4,
                ),
                35
            ),
            Arguments.of(
                listOf(
                    28,
                    33,
                    18,
                    42,
                    31,
                    14,
                    46,
                    20,
                    48,
                    47,
                    24,
                    23,
                    49,
                    45,
                    19,
                    38,
                    39,
                    11,
                    1,
                    32,
                    25,
                    35,
                    8,
                    17,
                    7,
                    9,
                    4,
                    2,
                    34,
                    10,
                    3,
                ),
                220
            )
        )

        @JvmStatic
        fun part2() = listOf(
            Arguments.of(
                listOf(
                    16,
                    10,
                    15,
                    5,
                    1,
                    11,
                    7,
                    19,
                    6,
                    12,
                    4,
                ),
                8
            ),
            Arguments.of(
                listOf(
                    28,
                    33,
                    18,
                    42,
                    31,
                    14,
                    46,
                    20,
                    48,
                    47,
                    24,
                    23,
                    49,
                    45,
                    19,
                    38,
                    39,
                    11,
                    1,
                    32,
                    25,
                    35,
                    8,
                    17,
                    7,
                    9,
                    4,
                    2,
                    34,
                    10,
                    3,
                ),
                19208
            )
        )
    }
}