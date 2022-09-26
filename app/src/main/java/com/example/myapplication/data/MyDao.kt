package uz.data.debts_apk.data


import androidx.room.*
import uz.data.debts_apk.model.User

@Dao
interface MyDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM debts")
    fun getAllUsers():List<User>

    @Delete
    suspend fun delete(user: User)
}