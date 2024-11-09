package com.gubo.duszaverseny.database

import org.jetbrains.exposed.sql.Table

object ProgLang: Table("ProgLang") {
    val id = integer("id").autoIncrement()
    val progLangName = varchar("progLangName", 255)
    override val primaryKey = PrimaryKey(id)
}