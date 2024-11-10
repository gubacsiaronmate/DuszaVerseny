package com.gubo.duszaverseny.repositories

import com.gubo.duszaverseny.data.Student
import com.gubo.duszaverseny.database.Students
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

suspend fun getStudents(): List<Student> =
    withContext(Dispatchers.IO) {
    return@withContext transaction {
        val students = Students.selectAll()
        return@transaction students.map {
            Student(
                id = it[Students.id],
                sName = it[Students.sName],
                grade = it[Students.grade]
            )
        }
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

fun modifyStudent(student: Student) = transaction {
    Students.update({ Students.id eq student.id }) {
        it[sName] = student.sName
        it[grade] = student.grade
    }
}

fun deleteStudent(id: Int) = transaction {
    Students.deleteWhere { Students.id eq id }
}

fun addStudent(student: Student) = transaction {
    Students.insert {
        it[sName] = student.sName
        it[grade] = student.grade
    }
}