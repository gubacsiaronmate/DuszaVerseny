package com.gubo.duszaverseny.database

import org.jetbrains.exposed.sql.Table

object Teams: Table("Team") {
    val id = integer("id").autoIncrement()
    val teamName = varchar("teamName", 255)
    val teamMate1 = integer("teamMate1").uniqueIndex().references(Students.id)
    val teamMate2 = integer("teamMate2").uniqueIndex().references(Students.id)
    val teamMate3 = integer("teamMate3").uniqueIndex().references(Students.id)
    val swapMate = integer("swapMate").uniqueIndex().references(Students.id).nullable()
    val teacherId1 = integer("teacherId1").references(Teachers.id)
    val teacherId2 = integer("teacherId2").references(Teachers.id).nullable()
    val teacherId3 = integer("teacherId3").references(Teachers.id).nullable()
    val chosenProgLang = integer("chosenProgLang").references(ProgLangs.id)
    val chosenCategory = integer("chosenCategory").references(Categories.id)

    override val primaryKey = PrimaryKey(id)
}