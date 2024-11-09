package com.gubo.duszaverseny.repositories

import com.gubo.duszaverseny.data.ProgLang
import com.gubo.duszaverseny.database.ProgLangs
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

fun getProgLangs(): List<ProgLang> = transaction{
    val progLangs = ProgLangs.selectAll()
    return@transaction progLangs.map {
        ProgLang(
            id = it[ProgLangs.id],
            progLangName = it[ProgLangs.progLangName]
        )
    }
}

fun getProgLangById(id: Int): ProgLang? = transaction {
    val progLang = ProgLangs.selectAll().firstOrNull { it[ProgLangs.id] == id }
    return@transaction if (progLang != null) {
        ProgLang(
            id = progLang[ProgLangs.id],
            progLangName = progLang[ProgLangs.progLangName]
        )
    } else null
}

fun modifyProgLang(progLang: ProgLang) = transaction {
    ProgLangs.update({ ProgLangs.id eq progLang.id }) {
        it[progLangName] = progLang.progLangName
    }
}

fun deleteProgLang(id: Int) = transaction {
    ProgLangs.deleteWhere { ProgLangs.id eq id }
}

fun addProgLang(progLang: ProgLang) = transaction {
    ProgLangs.insert {
        it[id] = progLang.id
        it[progLangName] = progLang.progLangName
    }
}