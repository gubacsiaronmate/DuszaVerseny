package com.gubo.duszaverseny.util

import kotlin.reflect.KClass

inline infix fun <reified T : Any> Any.convertTo(targetType: KClass<T>): Any = when (targetType) {
    Boolean::class -> toBooleanConversion()
    Byte::class -> toByteConversion()
    Short::class -> toShortConversion()
    Int::class -> toIntConversion()
    Long::class -> toLongConversion()
    Float::class -> toFloatConversion()
    Double::class -> toDoubleConversion()
    Char::class -> toCharConversion()
    String::class -> toStringConversion()
    List::class -> toListConversion()
    Array::class -> toArrayConversion()
    Set::class -> toSetConversion()
    Map::class -> toMapConversion()
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
