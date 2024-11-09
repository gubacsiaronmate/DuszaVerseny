package com.gubo.duszaverseny.export

import com.gubo.duszaverseny.data.Team
import com.gubo.duszaverseny.repositories.getTeams
import com.gubo.duszaverseny.util.buildString
import java.io.BufferedWriter
import java.io.OutputStream

class Export(private val filePath: String) {
    private fun getData(): List<Team> = getTeams()

    private fun convertData(): List<String> {
        val data: List<Team> = getData()
        val result = mutableListOf<String>()
        val sep = ","
        data.forEach { team ->
            result.add(buildString {
                +team.id
                +sep
                +team.teamName
                +sep
                team.teamMates.forEach{ student ->
                    +student?.id!!
                    +sep
                    +student.sName
                    +sep
                    +student.grade
                    +sep
                }
                team.teachers.forEach { teacher ->
                    +teacher?.id!!
                    +sep
                    +teacher.tName
                    +sep
                }
                +team.chosenProgLang
                +sep
                +team.chosenCategory
                +sep
            })
        }
        return result
    }

    private fun OutputStream.writeCSV(data: List<String>) {
        val writer = BufferedWriter(this.writer())
        data.forEach { line ->
            writer.write(line)
        }
    }

    fun writeData() {
        val data = convertData()
        val file = java.io.File(filePath)
        file.outputStream().writeCSV(data)
    }
}