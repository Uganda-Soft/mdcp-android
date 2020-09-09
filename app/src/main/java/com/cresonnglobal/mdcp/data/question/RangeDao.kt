package com.cresonnglobal.mdcp.data.question

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RangeDao {
    @Insert
    fun insertRange(rangeDao: Range)
    @Query("SELECT * FROM range WHERE typeId =:typeId")
    fun getRangeForType(typeId: Int): Range
}