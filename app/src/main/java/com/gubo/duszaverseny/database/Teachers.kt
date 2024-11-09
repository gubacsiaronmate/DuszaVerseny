package com.gubo.duszaverseny.database

import org.jetbrains.exposed.sql.Table

object Teachers: Table("Teacher") {
    val id = integer("id").autoIncrement()
    val tName = varchar("tName", 255)
    override val primaryKey = PrimaryKey(id)
}