package com.gubo.duszaverseny.util

import kotlin.reflect.full.findAnnotation

inline fun <reified T : Annotation> Any.getAnnotation(): T? {
    return this::class.findAnnotation<T>()
}