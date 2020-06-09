package irina.inashvili.shualeduri2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Activity")
data class DataMode (
    @PrimaryKey
    @ColumnInfo(name = "STEPS")
    var steps: Int = -1,

    @ColumnInfo(name = "WATER_DRINKS")
    var water: String = "",

    @ColumnInfo(name = "SLEEP_RECORD")
    var sleep: Int = -1
)