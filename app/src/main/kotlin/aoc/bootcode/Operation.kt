package aoc.bootcode

val OPERATIONS = listOf(AccumulatorOperation, JumpOperation, NoOperation).associateBy { it.opcode }

abstract class Operation(val opcode: String) {
    abstract fun execute(device: Device, argument: Int)
}

object AccumulatorOperation : Operation("acc") {
    override fun execute(device: Device, argument: Int) {
        device.accumulator += argument
        device.pointer++
    }
}

object JumpOperation : Operation("jmp") {
    override fun execute(device: Device, argument: Int) {
        device.pointer += argument
    }
}

object NoOperation : Operation("nop") {
    override fun execute(device: Device, argument: Int) {
        device.pointer++
    }
}