package com.fpinkotlin.recursion.exercise02

object Factorial {
    val factorial: (Int)-> Int = {
        tailrec fun fact(x: Int, ans: Int): Int {
            if(x == 0) return ans
            return fact(x - 1, ans * x)
        }
        fact(it, 1)
    }
}