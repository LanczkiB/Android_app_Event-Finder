package hu.bme.aut.hazi.data.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.io.Serializable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "activity")
data class ActivityItem (
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) var id: Long? = null,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "picture") var picture: Int,
    @ColumnInfo(name = "type") var type: Int,
    @ColumnInfo(name = "date") var date: String,
    @ColumnInfo(name = "parti") var parti: String
) : Parcelable