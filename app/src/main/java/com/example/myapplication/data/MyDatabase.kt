package uz.data.debts_apk.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.data.debts_apk.model.User

@Database(entities = [User::class], version = 1)
abstract class MyDatabase:RoomDatabase() {

    abstract fun getDao():MyDao

    companion object{

        @Volatile
        private var instance : MyDatabase?=null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance= it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            MyDatabase::class.java,
            "debts-database"
        ).build()
    }

}