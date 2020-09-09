package com.cresonnglobal.mdcp.data.question

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface MetaDao {
    @Insert
    fun insertMeta(meta: Meta)
    fun getLatestMeta(): Meta
}