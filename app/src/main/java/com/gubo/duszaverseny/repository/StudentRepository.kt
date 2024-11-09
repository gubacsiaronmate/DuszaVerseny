package com.gubo.duszaverseny.repository

import com.gubo.duszaverseny.data.Student
import com.gubo.duszaverseny.database.Students
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

fun getStudents(): List<Student> = transaction{
    val students = Students.selectAll()
    return@transaction students.map {
        Student(
            id = it[Students.id],
            sName = it[Students.sName],
            grade = it[Students.grade]
        )
    }
}

fun getStudentById(id: Int): Student? = transaction{
    val student = Students.selectAll().firstOrNull { it[Students.id] == id }
    return@transaction if (student != null) {
        Student(
            id = student[Students.id],
            sName = student[Students.sName],
            grade = student[Students.grade]
        )
    } else null
}