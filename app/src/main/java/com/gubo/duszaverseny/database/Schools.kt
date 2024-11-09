package com.gubo.duszaverseny.database

import org.jetbrains.exposed.sql.Table

object Schools: Table("School") {
    val id = integer("id").autoIncrement()
    val schoolName = varchar("schoolName", 255)
    val schoolAddress = varchar("schoolAddress", 255)
    val schoolUserName = varchar("schoolUserName", 255)
    override val primaryKey = PrimaryKey(id)

}