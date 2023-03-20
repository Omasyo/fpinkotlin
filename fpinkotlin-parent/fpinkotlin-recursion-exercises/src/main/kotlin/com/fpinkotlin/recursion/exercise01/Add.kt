package com.fpinkotlin.recursion.exercise01


tailrec fun add(a: Int, b: Int): Int {
    if(b > 0) return add(inc(a), dec(b))
    return a
}

fun inc(n: Int) = n + 1
fun dec(n: Int) = n - 1

