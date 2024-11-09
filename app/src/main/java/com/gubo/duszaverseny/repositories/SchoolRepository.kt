package com.gubo.duszaverseny.repositories

import com.gubo.duszaverseny.data.School
import com.gubo.duszaverseny.database.Schools
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

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

fun modifySchool(school: School) = transaction {
    Schools.update({ Schools.id eq school.id }) {
        it[schoolName] = school.schoolName
        it[schoolAddress] = school.schoolAddress
        it[schoolUserName] = school.schoolUserName
    }
}

fun deleteSchool(id: Int) = transaction {
    Schools.deleteWhere { Schools.id eq id }
}

fun addSchool(school: School) = transaction {
    Schools.insert {
        it[schoolName] = school.schoolName
        it[schoolAddress] = school.schoolAddress
        it[schoolUserName] = school.schoolUserName
    }
}