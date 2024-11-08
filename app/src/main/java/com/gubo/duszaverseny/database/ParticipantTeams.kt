package com.gubo.duszaverseny.database

import org.jetbrains.exposed.sql.Table

object ParticipantTeams: Table("participantTeams") {
    val participantId = integer("participantId")
    val teamName = varchar("teamName", 255)
}