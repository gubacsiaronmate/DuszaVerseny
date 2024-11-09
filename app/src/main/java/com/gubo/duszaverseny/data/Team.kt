package com.gubo.duszaverseny.data

data class Team(
    val id: Int,
    val teamName: String,
    val teamMates: List<Student>,
    val teachers: List<Teacher>,
    val chosenProgLang: ProgLang,
    val chosenCategory: Category
)
