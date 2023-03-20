package com.fpinkotlin.recursion.exercise16


fun <T> iterate(seed: T, f: (T) -> T, n: Int): List<T> {
    tailrec fun exec(seed: T, n: Int, acc: List<T>) : List<T> {
        if(n == 0) return acc
        return exec(f(seed), n-1, acc + seed)
    }
    return exec(seed, n, listOf())
}