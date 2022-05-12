package hu.bme.aut.hazi.data.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class ActivityWithUsers(
    @Embedded val activity: ActivityItem,
    @Relation(
        parentColumn = "name",
        entityColumn = "email",
        associateBy = Junction(UserActivityCrossRef::class)
    )
    val users: List<UserItem>
)