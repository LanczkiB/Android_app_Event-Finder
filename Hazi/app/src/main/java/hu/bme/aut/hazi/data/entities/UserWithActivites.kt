package hu.bme.aut.hazi.data.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation

@Entity(tableName = "userwithactivities")
data class UserWithActivites (
    @Embedded val user: UserItem,
    @Relation(
        parentColumn = "email",
        entityColumn = "name",
        associateBy = Junction(UserActivityCrossRef::class)
    )
    val activites: List<ActivityItem>
    )
