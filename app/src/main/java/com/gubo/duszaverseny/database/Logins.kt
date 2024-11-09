package com.gubo.duszaverseny.database

import org.jetbrains.exposed.sql.Table

object Logins: Table("Login") {
    val id = integer("id").autoIncrement()
    val username = varchar("username", 255)
    val password = varchar("password", 255)
    val teamId = integer("teamId").uniqueIndex().references(Teams.id)
    override val primaryKey = PrimaryKey(id)

}