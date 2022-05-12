package hu.bme.aut.hazi.data

import androidx.room.*
import hu.bme.aut.hazi.data.entities.*

@Dao
interface UserItemDao {
    @Query("SELECT * FROM user")
    fun getAllUsers(): List<UserItem>

    @Query("SELECT * FROM activity")
    fun getAllActivity(): List<ActivityItem>

    @Query("SELECT * FROM activity where name= :em")
    fun getActivityWhere(em:String): List<ActivityItem>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(shoppingItems: UserItem) :Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertActivity(shoppingItems: ActivityItem) :Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserActivityCrossRef(crossRef: UserActivityCrossRef)



    @Update
    fun update(shoppingItem: ActivityItem)

    @Delete
    fun deleteUser(shoppingItem: UserItem)

    @Delete
    fun deleteActivity(shoppingItem: ActivityItem)


    @Query("SELECT * FROM activity WHERE type = :type")
    fun getTypeActivity(type: Int): List<ActivityItem>

    @Transaction
    @Query("SELECT * FROM activity WHERE name = :name")
    fun getUsersOfActivity(name: String): List<ActivityWithUsers>


    @Transaction
    @Query("SELECT * FROM user WHERE email = :email")
    fun getActivysOfUser(email: String): List<UserWithActivites>

    @Query("DELETE FROM activity")
    fun deleteAll()

    @Query("DELETE FROM crossrefs WHERE email=:email and name=:name")
    fun deleteCrossRef(email:String,name:String)
}