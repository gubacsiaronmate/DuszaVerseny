package com.gubo.duszaverseny.repository

import com.gubo.duszaverseny.data.Teacher
import com.gubo.duszaverseny.database.Teachers
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

fun getTeachers(): List<Teacher> = transaction {
    val teachers = Teachers.selectAll()
    return@transaction teachers.map {
        Teacher(
            id = it[Teachers.id],
            tName = it[Teachers.tName]
        )
    }
}

fun getTeacherById(id: Int): Teacher? = transaction {
    val  teacher = Teachers.selectAll().firstOrNull{ it[Teachers.id] == id }
    return@transaction if (teacher != null) {
        Teacher(
            id = teacher[Teachers.id],
            tName = teacher[Teachers.tName]
        )
    } else null
}