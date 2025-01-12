package com.fpinkotlin.recursion.exercise15

import io.kotlintest.properties.Gen
import io.kotlintest.properties.forAll
import io.kotlintest.specs.StringSpec


class FibonacciTest : StringSpec() {

    init {
        "fibonacci" {
            forAll(100, Gen.choose(3, 300)) { n ->
                fibo(n - 1) == fibo(n).substringBeforeLast(",")
            }
        }
    }
}