package com.gubo.duszaverseny.database

import ch.vorburger.mariadb4j.DB
import ch.vorburger.mariadb4j.DBConfigurationBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.Database

suspend fun configureDatabase() {
    withContext(Dispatchers.IO) {
        val config = DBConfigurationBuilder.newBuilder()
        config.setPort(3306) // Set the port for the database
        config.setDataDir("com.gubo.duszaverseny/databases")

        val db = DB.newEmbeddedDB(config.build())
        db.start()

        Database.connect(
            url = "jdbc:mysql://35.157.40.252:3306/duszadb",
            driver = "org.mariadb.jdbc.Driver",
            user = "dusza",
            password = "TA#P\$D@quHMwja4U"
        )
    }
}