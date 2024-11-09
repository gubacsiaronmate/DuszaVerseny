package com.gubo.duszaverseny.repository

import com.gubo.duszaverseny.data.Team
import com.gubo.duszaverseny.database.Teams
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

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

fun getTeamById(id: Int): Team? = transaction {
    val team = Teams.selectAll().firstOrNull { it[Teams.id] == id }
    return@transaction if (team != null) {
        Team(
            id = team[Teams.id],
            teamName = team[Teams.teamName],
            teamMates = listOf(
                getStudentById(team[Teams.teamMate1]),
                getStudentById(team[Teams.teamMate2]),
                getStudentById(team[Teams.teamMate3]),
                if (team[Teams.swapMate] != null) getStudentById(team[Teams.swapMate]!!) else null
            ),
            teachers = listOf(
                getTeacherById(team[Teams.teacherId1]),
                if (team[Teams.teacherId2] != null) getTeacherById(team[Teams.teacherId2]!!) else null,
                if (team[Teams.teacherId3] != null) getTeacherById(team[Teams.teacherId3]!!) else null
            ),
            chosenProgLang = getProgLangById(team[Teams.chosenProgLang])!!,
            chosenCategory = getCategoryById(team[Teams.chosenCategory])!!
        )
    } else null
}

fun modifyTeam(team: Team) = transaction {
    Teams.update({ Teams.id eq team.id }) {
        it[teamName] = team.teamName
        it[teamMate1] = team.teamMates[0]?.id ?: 0
        it[teamMate2] = team.teamMates[1]?.id ?: 0
        it[teamMate3] = team.teamMates[2]?.id ?: 0
        it[swapMate] = team.teamMates[3]?.id
        it[teacherId1] = team.teachers[0]?.id ?: 0
        it[teacherId2] = team.teachers[1]?.id ?: 0
        it[teacherId3] = team.teachers[2]?.id ?: 0
        it[chosenProgLang] = team.chosenProgLang.id
        it[chosenCategory] = team.chosenCategory.id
    }
}

fun deleteTeam(id: Int) = transaction {
    Teams.deleteWhere { Teams.id eq id }
}

fun addTeam(team: Team) = transaction {
    Teams.insert {
        it[teamName] = team.teamName
        it[teamMate1] = team.teamMates[0]?.id ?: 0
        it[teamMate2] = team.teamMates[1]?.id ?: 0
        it[teamMate3] = team.teamMates[2]?.id ?: 0
        it[swapMate] = team.teamMates[3]?.id
        it[teacherId1] = team.teachers[0]?.id ?: 0
        it[teacherId2] = team.teachers[1]?.id ?: 0
        it[teacherId3] = team.teachers[2]?.id ?: 0
        it[chosenProgLang] = team.chosenProgLang.id
        it[chosenCategory] = team.chosenCategory.id
    }
}