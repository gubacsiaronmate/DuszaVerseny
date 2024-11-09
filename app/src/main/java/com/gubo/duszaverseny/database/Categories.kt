package com.gubo.duszaverseny.database

import org.jetbrains.exposed.sql.Table

object Categories: Table("Category") {
    val id = integer("id").autoIncrement()
    val categoryName = varchar("categoryName", 255)

    override val primaryKey = PrimaryKey(id)

}