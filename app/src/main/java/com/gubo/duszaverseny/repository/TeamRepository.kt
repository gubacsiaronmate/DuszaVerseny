package com.gubo.duszaverseny.repository

import com.gubo.duszaverseny.data.Team
import com.gubo.duszaverseny.database.Teams
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

fun getTeams(): List<Team> = transaction{
    val teams = Teams.selectAll()
    return@transaction teams.map {
        Team(
            id = it[Teams.id],
            teamName = it[Teams.teamName],
            teamMates = listOf(
                getStudentById(it[Teams.teamMate1]),
                getStudentById(it[Teams.teamMate2]),
                getStudentById(it[Teams.teamMate3]),
                if (it[Teams.swapMate] != null) getStudentById(it[Teams.swapMate]!!) else null
            ),
            teachers = listOf(
                getTeacherById(it[Teams.teacherId1]),
                if (it[Teams.teacherId2] != null) getTeacherById(it[Teams.teacherId2]!!) else null,
                if (it[Teams.teacherId3] != null) getTeacherById(it[Teams.teacherId3]!!) else null
            ),
            chosenProgLang = getProgLangById(it[Teams.chosenProgLang])!!,
            chosenCategory = getCategoryById(it[Teams.chosenCategory])!!
        )
    }
}