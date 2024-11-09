package com.gubo.duszaverseny.repository

import com.gubo.duszaverseny.data.Login
import com.gubo.duszaverseny.database.Logins
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

fun getLogins(): List<Login> = transaction{
    val logins = Logins.selectAll()
    return@transaction logins.map {
        Login(
            id = it[Logins.id],
            userName = it[Logins.username],
            password = it[Logins.password],
            teamId = it[Logins.teamId]
        )
    }
}

fun getLoginById(id: Int): Login? = transaction {
    val login = Logins.selectAll().firstOrNull { it[Logins.id] == id }
    return@transaction if (login != null) {
        Login(
            id = login[Logins.id],
            userName = login[Logins.username],
            password = login[Logins.password],
            teamId = login[Logins.teamId]
        )
    } else null
}

fun modifyLogin(login: Login) = transaction {
    Logins.update({ Logins.id eq login.id }) {
        it[username] = login.userName
        it[password] = login.password
        it[teamId] = login.teamId
    }
}

fun deleteLogin(id: Int) = transaction {
    Logins.deleteWhere { Logins.id eq id }
}

fun addLogin(login: Login) = transaction {
    Logins.insert {
        it[username] = login.userName
        it[password] = login.password
        it[teamId] = login.teamId
    }
}