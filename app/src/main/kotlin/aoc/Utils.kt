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

    @Suppress("Unchecked_cast")
    fun <T> twoSum(target: T, elements: List<T>): Pair<T, T>? where T: Number, T: Comparable<T> {
        val seen = mutableSetOf<T>()

        elements.forEach { e ->
            val compliment = (target - e) as T

            if (compliment in seen) {
                return Pair(e, compliment)
            }

            seen.add(e)
        }

        return null
    }

    operator fun Number.minus(other: Number): Number {
        return when (this) {
            is Long   -> this.toLong() - other.toLong()
            is Int    -> this.toInt()  - other.toInt()
            else      -> throw RuntimeException("add this numeric type")
        }
    }
}