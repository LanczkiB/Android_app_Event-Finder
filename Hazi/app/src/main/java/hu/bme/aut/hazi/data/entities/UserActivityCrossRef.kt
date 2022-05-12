package hu.bme.aut.hazi.data.entities

import androidx.room.Entity

@Entity(tableName = "crossrefs",primaryKeys = ["email", "name"])
data class UserActivityCrossRef(
    val email: String,
    val name: String
)