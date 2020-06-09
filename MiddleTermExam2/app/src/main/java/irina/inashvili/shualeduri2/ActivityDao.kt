package irina.inashvili.shualeduri2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ActivityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: DataMode)

    @Query("SELECT * FROM Activity")
    fun getActivity(): List<DataMode>
}