package com.cresonnglobal.mdcp.data.question

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface RangeDao {
    @Insert
    fun insertRange(rangeDao: RangeDao)
}