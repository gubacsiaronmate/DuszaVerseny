package com.gubo.duszaverseny.util

import kotlin.reflect.KClass

inline infix fun <reified T : Any> Any.convertTo(targetType: KClass<T>): T = when (targetType) {
    Boolean::class -> toBooleanConversion() as T
    Byte::class -> toByteConversion() as T
    Short::class -> toShortConversion() as T
    Int::class -> toIntConversion() as T
    Long::class -> toLongConversion() as T
    Float::class -> toFloatConversion() as T
    Double::class -> toDoubleConversion() as T
    Char::class -> toCharConversion() as T
    String::class -> toStringConversion() as T
    List::class -> toListConversion() as T
    Array::class -> toArrayConversion() as T
    Set::class -> toSetConversion() as T
    Map::class -> toMapConversion() as T
    else -> throw ClassCastException("Unsupported type: $targetType")
}

fun Any.toBooleanConversion(): Boolean = this.toString().toBoolean()
fun Any.toByteConversion(): Byte = this.toString().toByte()
fun Any.toShortConversion(): Short = this.toString().toShort()
fun Any.toIntConversion(): Int = this.toString().toInt()
fun Any.toLongConversion(): Long = this.toString().toLong()
fun Any.toFloatConversion(): Float = this.toString().toFloat()
fun Any.toDoubleConversion(): Double = this.toString().toDouble()
fun Any.toCharConversion(): Char = this.toString().toInt().toChar()
fun Any.toStringConversion(): String = this.toString()
fun Any.toListConversion(): List<Any?> = listOf(this)
fun Any.toArrayConversion(): Array<Any?> = arrayOf(this)
fun Any.toSetConversion(): Set<Any?> = setOf(this)
fun Any.toMapConversion(): Map<Any?, Any?> {
    val pair = this as Pair<Any?, Any?>
    return mapOf(pair)
}