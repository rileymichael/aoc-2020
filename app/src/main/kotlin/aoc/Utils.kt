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

    fun <T> Iterable<T>.split(predicate: (T) -> Boolean) = fold(mutableListOf(mutableListOf<T>())) { acc, e ->
        if (predicate(e)) {
            acc.add(mutableListOf())
        } else {
            acc.last() += e
        }

        acc
    }
}