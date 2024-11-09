package com.gubo.duszaverseny.database

import org.jetbrains.exposed.sql.Table

object Student: Table("Student") {
    val id = integer("id").autoIncrement()
    val grade = integer("grade")
    val pName = varchar("pName", 255)
    override val primaryKey = PrimaryKey(id)
}