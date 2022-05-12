package hu.bme.aut.hazi.data.entities

import android.content.Context
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import hu.bme.aut.hazi.ItemManager
import hu.bme.aut.hazi.data.UserItemDao
import hu.bme.aut.hazi.data.UserListDatabase

@Entity(tableName = "user")
data class UserItem(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) var id: Long? = null,
    @ColumnInfo(name = "email") var email: String,
    @ColumnInfo(name = "password") var password: String
){


}