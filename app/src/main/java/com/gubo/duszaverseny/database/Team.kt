package com.gubo.duszaverseny.database

import org.jetbrains.exposed.sql.Table

object Team: Table("Team") {
    val id = integer("id").autoIncrement()
    val teamName = varchar("teamName", 255)
    val teamMate1 = integer("teamMate1").uniqueIndex().references(Student.id)
    val teamMate2 = integer("teamMate2").uniqueIndex().references(Student.id)
    val teamMate3 = integer("teamMate3").uniqueIndex().references(Student.id)
    val swapMate = integer("swapMate").uniqueIndex().references(Student.id).nullable()
    val teacherId1 = integer("teacherId1").references(Teacher.id)
    val teacherId2 = integer("teacherId2").references(Teacher.id).nullable()
    val teacherId3 = integer("teacherId3").references(Teacher.id).nullable()
    val chosenProgLang = integer("chosenProgLang").references(ProgLang.id)
    val chosenCategory = integer("chosenCategory").references(Category.id)

    override val primaryKey = PrimaryKey(id)
}