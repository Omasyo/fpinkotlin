package com.fpinkotlin.recursion.exercise15

import java.math.BigInteger


fun <T> List<T>.head(): T =
    if (this.isEmpty())
        throw IllegalArgumentException("head called on empty list")
    else
        this[0]

fun <T> List<T>.tail(): List<T> =
    if (this.isEmpty())
        throw IllegalArgumentException("tail called on empty list")
    else
        this.subList(1, this.size)

fun <T, U> foldLeft(list: List<T>, z: U, f: (U, T) -> U): U {
    tailrec fun foldLeft_(list: List<T>, acc: U, f: (U, T) -> U): U =
        if (list.isEmpty())
            acc
        else
            foldLeft_(list.tail(), f(acc, list.head()), f)
    return foldLeft_(list, z, f)
}

fun fibo(number: Int): String {
    val builder = StringBuilder("0, 1")
    tailrec fun exec(x: BigInteger, y: BigInteger, count: Int) {
        if(count == number) {
            builder.append(", ${x+y}")
            return
        }
        builder.append(", ${x+y}")
        exec(y, x+y, count + 1)
    }
    exec(BigInteger.ZERO, BigInteger.ONE, 0)
    return builder.toString()
}

fun <T> makeString(list: List<T>, separator: String): String = TODO("makeString")
