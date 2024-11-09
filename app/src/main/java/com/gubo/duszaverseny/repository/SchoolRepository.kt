package com.gubo.duszaverseny.repository

import com.gubo.duszaverseny.data.School
import com.gubo.duszaverseny.database.Schools
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

fun getSchools(): List<School> = transaction{
    val schools = Schools.selectAll()
    return@transaction schools.map {
        School(
            id = it[Schools.id],
            schoolName = it[Schools.schoolName],
            schoolAddress = it[Schools.schoolAddress],
            schoolUserName = it[Schools.schoolUserName]
        )
    }
}

fun getSchoolById(id: Int): School? = transaction {
    val school = Schools.selectAll().firstOrNull { it[Schools.id] == id }
    return@transaction if (school != null) {
        School(
            id = school[Schools.id],
            schoolName = school[Schools.schoolName],
            schoolAddress = school[Schools.schoolAddress],
            schoolUserName = school[Schools.schoolUserName]
        )
    } else null
}