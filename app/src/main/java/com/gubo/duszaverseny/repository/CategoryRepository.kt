package com.gubo.duszaverseny.repository

import com.gubo.duszaverseny.data.Category
import com.gubo.duszaverseny.database.Categories
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

fun getCategories(): List<Category> = transaction{
    val categories = Categories.selectAll()
    return@transaction categories.map {
        Category(
            id = it[Categories.id],
            categoryName = it[Categories.categoryName]
        )
    }
}

fun getCategoryById(id: Int): Category? = transaction {
    val category = Categories.selectAll().firstOrNull{ it[Categories.id] == id }
    return@transaction if (category != null) {
        Category(
            id = category[Categories.id],
            categoryName = category[Categories.categoryName]
        )
    } else null
}