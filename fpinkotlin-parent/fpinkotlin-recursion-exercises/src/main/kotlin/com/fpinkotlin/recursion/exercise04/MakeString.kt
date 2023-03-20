package com.fpinkotlin.recursion.exercise04

fun <T> makeString(list: List<T>, delim: String): String {
    if(list.isEmpty()) return  ""
    tailrec fun makeString(list: List<T>, delim: String, ans: String): String {
        if(list.isEmpty()) return ans
        return makeString(list.tail(), delim,   ans + delim + list.head())
    }
    return makeString(list.tail(), delim, list.head().toString())
}

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
