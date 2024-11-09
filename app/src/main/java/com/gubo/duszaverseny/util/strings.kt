package com.gubo.duszaverseny.util

fun buildString(block: StringCollector.() -> Unit): String {
    val collector = StringCollector()
    collector.block()
    return collector.toString()
}

class StringCollector {
    private val builder = StringBuilder()

    operator fun String.unaryPlus() {
        builder.append(this)
    }

    operator fun Any.unaryPlus() {
        builder.append(this)
    }

    override fun toString(): String = builder.toString()
}