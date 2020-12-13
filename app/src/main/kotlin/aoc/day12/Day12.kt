package aoc.day12

import aoc.Utils
import kotlin.math.abs

fun main() {
    val input = Utils.readInput(12)

    val part1 = part1(input)
    println("Part 1: $part1")
}

fun part1(input: List<String>): Int {
    var facing = 90
    var position = Position(0, 0)
    input.parseInstructions().forEach { (action, value) ->
        when (action) {
            Action.NORTH -> position += Position(0, value)
            Action.SOUTH -> position += Position(0, value.unaryMinus())
            Action.EAST -> position += Position(value, 0)
            Action.WEST -> position += Position(value.unaryMinus(), 0)
            Action.LEFT -> {
                facing = (facing - value) % 360
                if (facing < 0) facing += 360
            }
            Action.RIGHT -> {
                facing = (facing + value) % 360
                if (facing < 0) facing += 360
            }
            Action.FORWARD -> when (facing) {
                0 -> { position += Position(0, value) }
                90 -> { position += Position(value, 0) }
                180 -> { position += Position(0, value.unaryMinus()) }
                270 -> { position += Position(value.unaryMinus(), 0) }
                else -> {} // ?
            }
        }
    }

    return abs(position.x) + abs(position.y)
}

typealias Instruction = Pair<Action, Int>

fun List<String>.parseInstructions(): List<Instruction> {
    return this.map {
        Action.fromChar(it.first()) to it.drop(1).toInt()
    }
}

data class Position(val x: Int, val y: Int) {
    operator fun plus(pos: Position) = Position(x + pos.x, y + pos.y)
    operator fun minus(pos: Position) = Position(x - pos.x, y - pos.y)
}

enum class Action(val char: Char) {
    NORTH('N'),
    SOUTH('S'),
    EAST('E'),
    WEST('W'),
    LEFT('L'),
    RIGHT('R'),
    FORWARD('F');

    companion object {
        private val byChar = values().associateBy { it.char }

        fun fromChar(c: Char) = byChar[c]!!
    }
}