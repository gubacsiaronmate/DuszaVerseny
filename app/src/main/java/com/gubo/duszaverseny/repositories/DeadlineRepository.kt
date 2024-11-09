package com.gubo.duszaverseny.repositories

import com.gubo.duszaverseny.data.Deadline
import com.gubo.duszaverseny.database.DeadlineTable
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

fun getDeadline(): Deadline? = transaction{
    val deadline = DeadlineTable.selectAll().firstOrNull()
    return@transaction if (deadline != null)
        Deadline(
            deadline[DeadlineTable.id],
            deadline[DeadlineTable.deadline]
        )
    else null
}