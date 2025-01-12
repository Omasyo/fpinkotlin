package com.fpinkotlin.trees.exercise01

sealed class Tree<out A: Comparable<@UnsafeVariance A>> {

    abstract fun isEmpty(): Boolean

    operator fun plus(a: @UnsafeVariance A): Tree<A> = when(this) {
        is Empty -> T(invoke(), a, invoke())
        is T -> when {
            a < this.value -> T(left + a, value, right)
            a > this.value -> T(left, value, right + a)
            else -> T(left, a, right)
        }
    }

    internal object Empty : Tree<Nothing>() {

        override fun isEmpty(): Boolean = true

        override fun toString(): String = "E"
    }

    internal class T<out A: Comparable<@UnsafeVariance A>>(internal val left: Tree<A>,
                            internal val value: A,
                            internal val right: Tree<A>) : Tree<A>() {

        override fun isEmpty(): Boolean = false

        override fun toString(): String = "(T $left $value $right)"
    }

    companion object {

        operator fun <A: Comparable<A>> invoke(): Tree<A> = Empty
    }
}
