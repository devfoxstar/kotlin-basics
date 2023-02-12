package devfoxstar.kotlin.basics

import java.lang.IllegalArgumentException

fun main() {
    println("#sum")
    println(sum(intArrayOf(1, 2, 3)))

    println("#aggregateSum")
    println(aggregateSum(intArrayOf(1, 2, 3)))

    println("#aggregateMax")
    println(aggregateMax(intArrayOf(1, 2, 3)))

    val lessThan: (Int, Int) -> Boolean = { a, b -> a < b}
    println("lessThan")
    println(lessThan(1, 2))

    val sum: (Int, Int) -> Int = { a, b -> a + b}
    println("sum")
    println(sum(1, 2))

    var moreThan = { a:Int, b:Int -> a > b }
    println("moreThan")
    println(moreThan(1, 2))

    val thisYear: (String) -> String = {
        "This year : $it"
    }
    println(thisYear("2023"))
}

fun sum(numbers: IntArray): Int {
    var result = numbers.firstOrNull()
        ?: throw IllegalArgumentException("Empty array")

    for (i in 1..numbers.lastIndex) result += numbers[i]

    return  result
}

fun aggregate(numbers: IntArray, op: (Int, Int) -> Int): Int {
    var result = numbers.firstOrNull()
        ?: throw IllegalArgumentException("Empty array")

    for (i in 1..numbers.lastIndex) result = op(result, numbers[i])

    return result
}

fun aggregateSum (numbers: IntArray) = aggregate(numbers, { result, op -> result + op })

fun aggregateMax (numbers: IntArray) = aggregate(numbers, { result, op -> if (op > result) op else result })