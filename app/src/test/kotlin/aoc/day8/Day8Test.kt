package aoc.day8

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day8Test {
    @Test
    fun part1() {
        val input = listOf(
            "nop +0",
            "acc +1",
            "jmp +4",
            "acc +3",
            "jmp -3",
            "acc -99",
            "acc +1",
            "jmp -4",
            "acc +6",
        )
        val actual = part1(input)
        Assertions.assertEquals(5, actual)
    }

    @Test
    fun part2() {
        val input = listOf(
            "nop +0",
            "acc +1",
            "jmp +4",
            "acc +3",
            "jmp -3",
            "acc -99",
            "acc +1",
            "jmp -4",
            "acc +6",
        )
        val actual = part2(input)
        Assertions.assertEquals(8, actual)
    }
}