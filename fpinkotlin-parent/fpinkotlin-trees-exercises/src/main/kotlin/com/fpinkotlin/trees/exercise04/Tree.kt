package com.fpinkotlin.trees.exercise04

import com.fpinkotlin.common.List

sealed class Tree<out A: Comparable<@UnsafeVariance A>> {

    abstract fun size(): Int

    abstract fun height(): Int

    abstract fun isEmpty(): Boolean

    operator fun plus(a: @UnsafeVariance A): Tree<A> = when (this) {
        Empty -> T(Empty, a, Empty)
        is T -> when {
            a < this.value -> T(left + a, this.value, right)
            a > this.value -> T(left, this.value, right + a)
            else -> T(this.left, a, this.right)
        }
    }

    fun contains(a: @UnsafeVariance A): Boolean = when (this) {
        Empty -> false
        is T -> when {
            a < value -> left.contains(a)
            a > value -> right.contains(a)
            else -> value == a
        }
    }

    internal object Empty : Tree<Nothing>() {
        override fun size(): Int = 0
        override fun height(): Int = -1

        override fun isEmpty(): Boolean = true

        override fun toString(): String = "E"
    }

    internal class T<out A: Comparable<@UnsafeVariance A>>(internal val left: Tree<A>,
                                                           internal val value: A,
                                                           internal val right: Tree<A>) : Tree<A>() {
        override fun size(): Int = 1 + left.size() + right.size()

        override fun height(): Int = 1 + Math.max(left.height(), right.height())

        override fun isEmpty(): Boolean = false

        override fun toString(): String = "(T $left $value $right)"
    }

    companion object {

        operator fun <A: Comparable<A>> invoke(): Tree<A> = Empty

        operator fun <A: Comparable<A>> invoke(vararg az: A): Tree<A> =
            az.fold(Empty) { tree: Tree<A>, a: A -> tree.plus(a) }

        operator fun <A: Comparable<A>> invoke(list: List<A>): Tree<A> =
            list.foldLeft(Empty as Tree<A>) { tree: Tree<A> -> { a: A -> tree.plus(a) } }
    }
}
