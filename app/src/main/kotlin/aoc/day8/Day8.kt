package aoc.day8

import aoc.Utils
import aoc.bootcode.Device

fun main() {
    val input = Utils.readInput(8)

    val part1 = part1(input)
    println("Part 1: $part1")

    val part2 = part2(input)
    println("Part 2: $part2")
}

fun part1(input: List<String>): Int {
    return Device(input).compute()
}

fun part2(input: List<String>): Int {
    val perms = input.asSequence().filter { "nop" in it || "jmp" in it }.map {
        val index = input.indexOf(it)
        val copy = input.toMutableList()
        if ("nop" in it) {
            copy[index] = it.replace("nop", "jmp")
        } else if ("jmp" in it) {
            copy[index] = it.replace("jmp", "nop")
        }
        copy
    }

    return perms.map(::Device).first {
        it.compute()
        it.finished
    }.accumulator
}