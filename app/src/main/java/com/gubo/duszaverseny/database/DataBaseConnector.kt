package com.gubo.duszaverseny.database

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.Database

suspend fun configureDatabase() {
    withContext(Dispatchers.IO) {
        Database.connect(
            url = "jdbc:mysql://35.157.40.252:3306/duszadb",
            driver = "com.mysql.cj.jdbc.Driver",
            user = "dusza",
            password = "TA#P\$D@quHMwja4U"
        )
    }
}