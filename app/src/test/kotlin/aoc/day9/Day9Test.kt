package aoc.day9

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day9Test {
    @Test
    fun part1() {
        val actual = findInvalid(5, input)
        Assertions.assertEquals(127, actual)
    }

    @Test
    fun part2() {
        val actual = part2(5, input)
        Assertions.assertEquals(62, actual)
    }

    companion object {
        private val input = listOf<Long>(
            35,
            20,
            15,
            25,
            47,
            40,
            62,
            55,
            65,
            95,
            102,
            117,
            150,
            182,
            127,
            219,
            299,
            277,
            309,
            576,
        )
    }
}