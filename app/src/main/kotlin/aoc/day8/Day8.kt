package aoc.day8

import aoc.Utils

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

fun part2(input: List<String>): Int? {
    val perms = input.map {
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

class Device(private val code: List<String>) {
    var pointer = 0
    var accumulator = 0
    val finished: Boolean
        get() = pointer == code.size

    private val executed = mutableSetOf<Int>()

    fun compute(): Int {
        while (pointer >= 0 && pointer < code.size && pointer !in executed) {
            val (operation, argument) = getInstruction()
            executed.add(pointer)
            operation.execute(argument)
        }
        return accumulator
    }

    private fun getInstruction(): Instruction {
        code[pointer].let { value ->
            val (op, arg) = value.split(" ")
            val operation = OPERATIONS[op] ?: error("Error: Instruction $value not found.")
            return Instruction(operation, arg.toInt())
        }
    }

    private fun Operation.execute(argument: Int) {
        this.execute(this@Device, argument)
    }

    companion object {
        private val OPERATIONS = mapOf(
            "acc" to AccumulatorOperation,
            "jmp" to JumpOperation,
            "nop" to NoOpInstruction
        )
    }
}

data class Instruction(val operation: Operation, val argument: Int)
abstract class Operation {
    abstract fun execute(device: Device, argument: Int)
}

object AccumulatorOperation : Operation() {
    override fun execute(device: Device, argument: Int) {
        device.accumulator += argument
        device.pointer++
    }
}

object JumpOperation : Operation() {
    override fun execute(device: Device, argument: Int) {
        device.pointer += argument
    }
}

object NoOpInstruction : Operation() {
    override fun execute(device: Device, argument: Int) {
        device.pointer++
    }
}
