package com.gubo.duszaverseny.database

import org.jetbrains.exposed.sql.Table

object Students: Table("Student") {
    val id = integer("id").autoIncrement()
    val grade = integer("grade")
    val sName = varchar("pName", 255)
    override val primaryKey = PrimaryKey(id)
}