package irina.inashvili.shualeduri2

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DataMode::class], version = 1)
abstract class DB : RoomDatabase()
{
    abstract fun dataDao(): ActivityDao
}