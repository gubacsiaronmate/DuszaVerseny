package com.gubo.duszaverseny.database

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object DeadlineTable : Table("Deadline") {
    val id = integer("id").autoIncrement()
    val deadline = datetime("deadline")
    override val primaryKey = PrimaryKey(id)
}