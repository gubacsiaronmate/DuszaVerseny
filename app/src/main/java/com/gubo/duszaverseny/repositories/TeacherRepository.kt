package com.gubo.duszaverseny.repositories

import com.gubo.duszaverseny.data.Teacher
import com.gubo.duszaverseny.database.Teachers
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

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

fun modifyTeacher(teacher: Teacher) = transaction {
    Teachers.update({ Teachers.id eq teacher.id }) {
        it[tName] = teacher.tName
    }
}

fun deleteTeacher(id: Int) = transaction {
    Teachers.deleteWhere { Teachers.id eq id }
}

fun addTeacher(teacher: Teacher) = transaction {
    Teachers.insert {
        it[tName] = teacher.tName
    }
}