package aoc.day12

import aoc.Utils
import kotlin.math.abs

fun main() {
    val input = Utils.readInput(12)

    val part1 = part1(input)
    println("Part 1: $part1")
    val part2 = part2(input)
    println("Part 2: $part2")
}

fun part1(input: List<String>): Int {
    var facing = 90
    var ship = Position(0, 0)
    input.parseInstructions().forEach { (action, value) ->
        when (action) {
            Action.NORTH -> ship += Position(0, value)
            Action.SOUTH -> ship += Position(0, value.unaryMinus())
            Action.EAST -> ship += Position(value, 0)
            Action.WEST -> ship += Position(value.unaryMinus(), 0)
            Action.LEFT -> facing = (facing - value).normalize()
            Action.RIGHT -> facing = (facing + value).normalize()
            Action.FORWARD -> when (facing) {
                0 -> ship += Position(0, value)
                90 -> ship += Position(value, 0)
                180 -> ship += Position(0, value.unaryMinus())
                270 -> ship += Position(value.unaryMinus(), 0)
                else -> { } // ?
            }
        }
    }

    return abs(ship.x) + abs(ship.y)
}

fun part2(input: List<String>): Int {
    var ship = Position(0, 0)
    var waypoint = Position(10, 1)

    input.parseInstructions().forEach { (action, value) ->
        when (action) {
            Action.NORTH -> waypoint += Position(0, value)
            Action.SOUTH -> waypoint += Position(0, value.unaryMinus())
            Action.EAST -> waypoint += Position(value, 0)
            Action.WEST -> waypoint += Position(value.unaryMinus(), 0)
            Action.LEFT -> waypoint = waypoint.rotate(value.unaryMinus())
            Action.RIGHT -> waypoint = waypoint.rotate(value)
            Action.FORWARD -> ship += waypoint * value
        }
    }

    return abs(ship.x) + abs(ship.y)
}

typealias Instruction = Pair<Action, Int>

fun List<String>.parseInstructions(): List<Instruction> {
    return this.map {
        Action.fromChar(it.first()) to it.drop(1).toInt()
    }
}

fun Int.normalize(): Int {
    var angle = this % 360
    if (angle < 0) angle += 360
    return angle
}

data class Position(val x: Int, val y: Int) {
    operator fun plus(pos: Position) = Position(x + pos.x, y + pos.y)
    operator fun minus(pos: Position) = Position(x - pos.x, y - pos.y)
    operator fun times(i: Int) = Position(x * i, y * i)

    fun rotate(degrees: Int) = when (degrees.normalize()) {
        90 -> Position(y, -x)
        180 -> Position(-x, -y)
        270 -> Position(-y, x)
        else -> this // ?
    }
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