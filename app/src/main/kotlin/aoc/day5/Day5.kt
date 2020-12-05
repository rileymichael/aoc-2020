package aoc.day5

import aoc.Utils

fun main() {
    val input = Utils.readInput(5)

    val part1 = part1(input)
    println("Part 1: $part1")

    val part2 = part2(input)
    println("Part 2: $part2")
}

typealias BoardingPass = String
typealias SeatId = Int

fun part1(input: List<BoardingPass>): SeatId? {
    return input.map(BoardingPass::decode).maxOrNull()
}

fun part2(input: List<BoardingPass>): SeatId? {
    val occupied = input.map(BoardingPass::decode).toSet()
    return (0..1023).firstOrNull { seatId ->
        seatId !in occupied && seatId.inc() in occupied && seatId.dec() in occupied
    }
}

fun BoardingPass.decode(): SeatId {
    return this
        .replace('F', '0', true)
        .replace('B', '1', true)
        .replace('R', '1', true)
        .replace('L', '0', true)
        .toInt(2)
}
