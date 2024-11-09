package com.gubo.util

import util.Color
import util.Kolor
import util.lightWhiteBackground

fun input (prompt: Any): Any {
    print(prompt)
    return readln()
}

class CustomException(message:String): Exception(message)

fun log(msg:Any, includeSuffix:Boolean = true, prefix:String = "\n\n\n", suffix:String = "\n\n\n") {
    if (includeSuffix) {
        println("$prefix${Kolor.foreground(msg.toString(), Color.BLACK).lightWhiteBackground()}$suffix")
    } else {
        println("$prefix${Kolor.foreground(msg.toString(), Color.BLACK).lightWhiteBackground()}")
    }
}

inline fun <T> measureTime(block: () -> T): T {
    val start = System.currentTimeMillis()
    val result = block()
    val end = System.currentTimeMillis()
    println("Time taken: ${end - start}ms")
    return result
}