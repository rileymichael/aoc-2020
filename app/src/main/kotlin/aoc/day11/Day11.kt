package aoc.day11

import aoc.Utils

fun main() {
    val input = Utils.readInput(11)

    val part1 = part1(input)
    println("Part 1: $part1")
    val part2 = part2(input)
    println("Part 2: $part2")
}

fun part1(input: List<String>) = passengerArrival(input.toGrid()) { shiftAdjacent(it) }

fun part2(input: List<String>) = passengerArrival(input.toGrid()) { shiftVisible(it) }

typealias Grid = Array<CharArray>

fun List<String>.toGrid(): Grid = this.map { it.toCharArray() }.toTypedArray()

fun passengerArrival(grid: Grid, visibilityMethod: (Grid) -> Grid): Int {
    var prev = emptyArray<CharArray>()
    var new = grid.copyOf()
    while (!new.contentDeepEquals(prev)) {
        prev = new
        new = visibilityMethod(prev)
    }
    return new.sumBy { row -> row.count { it == OCCUPIED } }
}

fun shiftAdjacent(grid: Grid): Grid {
    val newLayout = grid.map { it.copyOf() }.toTypedArray()
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            var occupied = 0
            ADJACENT.forEach { adj ->
                when (grid.getOrNull(i + adj.first)?.getOrNull(j + adj.second)) {
                    OCCUPIED -> {
                        occupied++
                    }
                }
            }

            if (grid[i][j] == EMPTY && occupied == 0) {
                newLayout[i][j] = OCCUPIED
            } else if (grid[i][j] == OCCUPIED && occupied >= 4) {
                newLayout[i][j] = EMPTY
            }
        }
    }
    return newLayout
}

fun shiftVisible(grid: Grid): Grid {
    val newLayout = grid.map { it.copyOf() }.toTypedArray()
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            var occupied = 0
            for (adj in ADJACENT) {
                var x2 = i
                var y2 = j
                while (true) {
                    x2 += adj.first
                    y2 += adj.second
                    when (grid.getOrNull(x2)?.getOrNull(y2)) {
                        OCCUPIED -> {
                            occupied++
                            break
                        }
                        EMPTY -> {
                            break
                        }
                        null -> break
                    }
                }
            }

            if (grid[i][j] == EMPTY && occupied == 0) {
                newLayout[i][j] = OCCUPIED
            } else if (grid[i][j] == OCCUPIED && occupied >= 5) {
                newLayout[i][j] = EMPTY
            }
        }
    }
    return newLayout
}

private val ADJACENT = listOf(
    Pair(0, 1),
    Pair(0, -1),
    Pair(-1, 0),
    Pair(1, 0),
    Pair(-1, 1),
    Pair(1, 1),
    Pair(1, -1),
    Pair(-1, -1)
)

private const val EMPTY = 'L'
private const val OCCUPIED = '#'
private const val FLOOR = '.'