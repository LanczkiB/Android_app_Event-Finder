package hu.bme.aut.hazi.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hu.bme.aut.hazi.data.entities.*

@Database(entities = [UserItem::class, ActivityItem::class, UserActivityCrossRef::class], version = 1)


abstract class UserListDatabase : RoomDatabase() {
    abstract fun UserItemDao(): UserItemDao

    companion object {

        fun getDatabase(applicationContext: Context): UserListDatabase {
            return Room.databaseBuilder(
                applicationContext,
                UserListDatabase::class.java,
                "user-list"
            ).build();
        }
    }
}