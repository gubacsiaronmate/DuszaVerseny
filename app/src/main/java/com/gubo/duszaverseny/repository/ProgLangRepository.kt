package com.gubo.duszaverseny.repository

import com.gubo.duszaverseny.data.ProgLang
import com.gubo.duszaverseny.database.ProgLangs
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

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