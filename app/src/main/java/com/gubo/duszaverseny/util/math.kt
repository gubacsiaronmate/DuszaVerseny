package com.gubo.duszaverseny.util

import kotlin.math.pow
import kotlin.math.round

infix fun Int.exp(exp: Int): Int = toDouble().pow(exp).toInt()
infix fun Long.exp(exp: Int): Long = toDouble().pow(exp).toLong()
infix fun Float.exp(exp: Int): Float = this.pow(exp)
infix fun Double.exp(exp: Int): Double = this.pow(exp)

infix fun Double.f(num: Int): Any = if (num == 0) round(this).toInt()
else String.format("%.${num}f", this).replace(",", ".").toDouble()