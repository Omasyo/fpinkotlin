package com.fpinkotlin.recursion.exercise03

import java.math.BigInteger


fun fib(x: Int): BigInteger {
    tailrec fun fib(a: BigInteger, b: BigInteger, count: Int) : BigInteger {
        if(count <= 1) return a + b
        return fib(b, a+b, count-1)
    }
    return fib(BigInteger.ZERO, BigInteger.ONE, x)
}
