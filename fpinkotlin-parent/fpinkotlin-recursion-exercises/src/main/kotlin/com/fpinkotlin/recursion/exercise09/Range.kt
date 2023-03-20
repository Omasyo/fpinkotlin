package com.fpinkotlin.recursion.exercise09


fun range(start: Int, end: Int): List<Int> {
    tailrec fun range(start: Int, acc: List<Int>): List<Int> {
        if(start == end) return acc
        return range(start + 1, acc + start )
    }
    return range(start, listOf())
}