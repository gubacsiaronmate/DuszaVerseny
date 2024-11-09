package com.gubo.duszaverseny.util

fun List<Int>.toMultiple(): Int {
    var sum = 1
    for ( item: Int in this ) { sum *= item }
    return sum
}

fun List<Long>.toMultiple(): Long {
    var sum: Long = 1
    for ( item: Long in this ) { sum *= item }
    return sum
}

fun List<Float>.toMultiple(): Float {
    var sum = 1.0F
    for ( item: Float in this ) { sum *= item }
    return sum
}

fun List<Double>.toMultiple(): Double {
    var sum = 1.0
    for ( item: Double in this ) { sum *= item }
    return sum
}