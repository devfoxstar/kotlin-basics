package devfoxstar.kotlin.basics

fun main() {
    println("#printDefault")
    printDefault("abc")
    //printDefault(null)      //Kotlin: Null can not be a value of a non-null type String

    println("#printNullable")
    printNullable(null)

    println("#printEmpty")
    printEmpty("abc")
    //printNullableEmpty(null)    //Kotlin: Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?

    println("#printIterator")
    printIterator("abc")
    printNullableIterator(null)     //Kotlin: Not nullable value required to call an 'iterator()' method on for-loop range

    println("#printNullableConcat")
    printNullableConcat(null)

    println("#checkSmartCast")
    println(checkSmartCast("abc"))
    println(checkSmartCast(null))

    println("#printElvis")
    printElvis("abc")

    println("#printNonElvis")
    printNonElvis(null)

    println("#printNonnull")
    printNonnull("abc")
    //printNonnull(null)      //Exception in thread "main" java.lang.NullPointerException
}

fun printDefault(s: String) {
    println(s)
}

fun printNullable(s: String?) {
    println(s)
}

fun printEmpty(s: String) {
    if (s.isEmpty()) println("Empty")
}

fun printNullableEmpty(s: String?) {
    //if (s.isEmpty()) println("Empty")
}

fun printIterator(s: String) {
    for (ch in s) {
        println(ch)
    }
}

fun printNullableIterator(s: String?) {
    /*
    for (ch in s) {
        println(ch)
    }
    */
}

fun printNullableConcat(s: String?) {
    println(s + "!")
}

fun checkSmartCast(s: String?): Boolean {
    if (s == null) return false
    if (s.isEmpty()) return false

    return true
}

fun printElvis(s: String?) {
    val l: Int = s?.length ?: 0
    println(l)
}

fun printNonElvis(s: String?) {
    val l: Int = if (s != null) s.length else 0
    println(l)
}

fun printNonnull(s: String?) {
    val l = s!!.length
    println(l)
}