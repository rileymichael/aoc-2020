package aoc.bootcode

class Device(private val bootcode: List<String>) {
    var pointer = 0
    var accumulator = 0
    val finished: Boolean
        get() = pointer == bootcode.size

    private val executed = mutableSetOf<Int>()

    fun compute(): Int {
        while (pointer >= 0 && pointer < bootcode.size && pointer !in executed) {
            val (operation, argument) = getInstruction()
            executed.add(pointer)
            operation.execute(argument)
        }
        return accumulator
    }

    private fun getInstruction(): Instruction {
        bootcode[pointer].let { value ->
            val (opcode, arg) = value.split(" ")
            val operation = OPERATIONS[opcode] ?: error("Error: Operation $opcode not found.")
            return Instruction(operation, arg.toInt())
        }
    }

    private fun Operation.execute(argument: Int) {
        this.execute(this@Device, argument)
    }
}