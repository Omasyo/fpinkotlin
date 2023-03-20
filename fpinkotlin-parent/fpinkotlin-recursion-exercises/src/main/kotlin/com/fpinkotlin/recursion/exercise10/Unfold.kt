package com.fpinkotlin.recursion.exercise10


fun <T> unfold(seed: T, f: (T) -> T, p: (T) -> Boolean): List<T> {
    tailrec fun unfold(seed: T, acc: List<T>) : List<T> {
        if(!p(seed)) return acc
        return unfold(f(seed), acc + seed)
    }
    return unfold(seed, listOf())
}

