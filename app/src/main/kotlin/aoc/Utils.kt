package aoc

object Utils {
    fun readInput(day: Int): List<String> {
        val lines = this::class.java
            .classLoader
            .getResourceAsStream("day$day")
            ?.bufferedReader()
            ?.readLines()

        requireNotNull(lines, { "Input for day $day not found."})

        return lines
    }
}