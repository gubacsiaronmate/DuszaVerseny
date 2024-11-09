package com.gubo.duszaverseny.repositories

import com.gubo.duszaverseny.data.Category
import com.gubo.duszaverseny.database.Categories
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
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

fun modifyCategory(category: Category) = transaction {
    Categories.update({ Categories.id eq category.id }) {
        it[categoryName] = category.categoryName
    }
}

fun deleteCategory(id: Int) = transaction {
    Categories.deleteWhere { Categories.id eq id }
}

fun addCategory(category: Category) = transaction {
    Categories.insert {
        it[id] = category.id
        it[categoryName] = category.categoryName
    }
}