package com.gubo.duszaverseny.data

data class Login(
    val id: Int, val userName: String,
    val password: String,
    val teamId: Int
)