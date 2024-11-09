package com.gubo.duszaverseny.database

import org.jetbrains.exposed.sql.Table

object Login: Table("Login") {
    val id = integer("id").autoIncrement()
    val username = varchar("username", 255)
    val password = varchar("password", 255)
    val teamId = integer("teamId").uniqueIndex().references(Team.id)
    override val primaryKey = PrimaryKey(id)

}