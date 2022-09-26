package uz.data.debts_apk.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "debts")
data class User(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "summa") val summa: Int,
    @ColumnInfo(name = "given_date") val givendate:String,
    @ColumnInfo(name = "get_day") val getday:String
    )