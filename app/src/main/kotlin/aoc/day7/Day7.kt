package aoc.day7

import aoc.Utils

fun main() {
    val input = Utils.readInput(7)

    val part1 = part1(input)
    println("Part 1: $part1")

    val part2 = part2(input)
    println("Part 2: $part2")
}

fun part1(input: List<String>): Int {
    return LuggageRegulations(input).eventuallyContains("shiny gold").count()
}

fun part2(input: List<String>): Int {
    return LuggageRegulations(input).requiredInside("shiny gold")
}

data class Bag(val color: String, val contents: Map<String, Int>)
class LuggageRegulations(input: List<String>) {
    private val bags by lazy {
        input.map { line ->
            val parent = parentRegex.find(line)?.groupValues?.get(1)!!
            val children = childrenRegex.findAll(line).map { match ->
                val amount = match.groupValues[1].toInt()
                val color = match.groupValues[2]
                Pair(color, amount)
            }.associate { it.first to it.second }
            Bag(parent, children)
        }
    }

    private val containedBy by lazy {
        val map = mutableMapOf<String, Set<String>>()
        bags.forEach { bag ->
            bag.contents.keys.forEach {
                map[it] = map.getOrDefault(it, mutableSetOf()) + bag.color
            }
        }
        map
    }

    private val contains by lazy { bags.associateBy { it.color } }

    fun eventuallyContains(color: String): MutableSet<String> {
        val found = mutableSetOf<String>()
        containedBy[color]?.let { bags ->
            bags.forEach { bag ->
                found.add(bag)
                found.addAll(eventuallyContains(bag))
            }
        }
        return found
    }

    fun requiredInside(color: String): Int {
        return contains[color]?.contents?.entries?.sumBy {
            it.value + (it.value * requiredInside(it.key))
        } ?: 0
    }

    companion object {
        private val parentRegex = Regex("(.+?) bags contain")
        private val childrenRegex = Regex("(\\d+) (.+?) bags?[,.]")
    }
}
