package com.fpinkotlin.workingwithlaziness.exercise01


class Lazy<out A>(function: () -> A): () -> A {

    val function = function

    var result: @UnsafeVariance A? = null

    // Add implementation

    override fun invoke(): A  {
        if(result == null) {
            result = function()
        }
        return result!!
    }
}