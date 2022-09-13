package devfoxstar.kotlin.basics

import kotlin.text.*

fun main() {
    println("#printText")
    printText()

    println("\n#printSum")
    println(sum(1, 2))
    println(sum2(2, 3))
    printSum(3, 4)

    println("\n#printVal")
    printVal()

    println("\n#printConstructor")
    printConstructor()

    println("\n#printInheritance")
    printInheritance()

    println("\n#printString")
    printString()

    println("\n#printCondition")
    println(maxOf(1, 2))
    println(maxOf2(2, 3))

    println("\n#printForLoop")
    printForLoop()
    printForLoop2()

    println("\n#printWhileLoop")
    printWhileLoop()

    println("\n#printWhen")
    println(describe(1))
    println(describe("이"))
    println(describe(3L))
    println(describe(4))
    println(describe("5"))

    println("\n#printRange")
    printRange()
    printRange2()
    printRange3()
    printRange4()
    printRange5()

    println("\n#printCollection")
    printCollection()
    printCollection2()
    printCollection3()

    println("\n#printNull")
    println(parseInt(""))
    printParseInt("1", "2")
    printParseInt("a", "3")
    printParseInt("b", "c")

    println("\nprintType")
    printLength("A")
    printLength(10)
    printLength(listOf(Any()))
}

//Print
fun printText() {
    print("Hello ")
    print("world ")
    println("Hello world!")
    println(43)
}

//Functions
fun sum(a:Int, b:Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int) = a + b

fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

//Variables
fun printVal() {
    val a: Int = 1
    val b = 2

    val c: Int
    c = 3

    var d = 4
    d += 1

    var e = 3.14

    println("a = $a, b = $b, c = $c, d = $d, e = $e")
}

//Creating classes and instances
class Rectangle(var height: Double, var length: Double) {
    var perimeter = (height + length) * 2
}

fun printConstructor() {
    var rectangle = Rectangle(1.0, 2.1)
    println("${rectangle.perimeter}")
}

//Inheritance
open class parentClass() {
    var a = "Inheritance"
}

class childClass(): parentClass() {
    var b = parentClass().a
}

fun printInheritance() {
    var c = childClass().b
    println(c)
}

//String templates
fun printString() {
    var a = 1
    a = 2

    var b = "Text"
    b = b.replace("T", "t")

    println("a = $a, b = $b")
}

//Conditional expressions
fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

fun maxOf2(a: Int, b: Int) = if (a > b) a else b

//for loop
fun printForLoop() {
    var items = listOf("A", "B", "C")
    for (item in items) {
        println(item)
    }
}

fun printForLoop2() {
    var items = listOf("A", "B", "C")
    for (index in items.indices) {
        println("${items[index]}")
    }
}

//while loop
fun printWhileLoop() {
    var items = listOf("A", "B", "C", "D", "E")
    var index = 2;
    while (index < items.size) {
        println("${items[index]}")
        index++
    }
}

//when expression
fun describe(obj: Any): String =
    when (obj) {
        1 -> "One"
        "이" -> "Two"
        is Long -> "Three"
        !is String -> "Four"
        else -> "Five"
    }

//Ranges
fun printRange () {
    val x = 10
    val y = 9
    if (x in 1..y+1) {
        println("fit in range")
    }
}

fun printRange2() {
    var list = listOf("a", "b", "c")

    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }

    if (list.size !in list.indices) {
        println("list size is out of valid list indices range, too")
    }
}

fun printRange3() {
    for (x in 1..3) {
        println(x)
    }
}

fun printRange4() {
    for (x in 1..10 step 2) {
        println(x)
    }
}

fun printRange5() {
    for (x in 10 downTo 0 step 2) {
        println(x)
    }
}

fun printCollection() {
    var items = listOf("A", "B", "C")
    for (item in items) {
        println(item)
    }
}

fun printCollection2() {
    var items = listOf("A", "B", "C")
    when {
        "A" in items -> println("a")
        "D" in items -> println("d")
    }
}

fun printCollection3() {
    var fruits = listOf("banana", "apple", "avocado", "kiwifruit")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { println(it) }
}

//Nullable values and null checks
fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printParseInt(arg1: String, arg2: String) {
    var x = parseInt(arg1)
    var y = parseInt(arg2)

    if (x != null && y != null) {
        println(x * y)
    } else {
        println("$arg1 / $arg2")
    }
}

//Type checks and automatic casts
fun getStringLength(obj: Any): Int? {
    if (obj !is String) return null

    return obj.length
}

fun printLength(obj: Any) {
    println("Getting the length of '$obj'. Result: ${getStringLength(obj) ?: "Error: The object is not a string"}")
}