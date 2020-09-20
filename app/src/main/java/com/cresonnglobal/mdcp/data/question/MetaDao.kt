package com.cresonnglobal.mdcp.data.question

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MetaDao {
    @Insert
    fun insertMeta(meta: Meta)

    @Query("SELECT * FROM meta ORDER BY id DESC LIMIT 1")
    fun getLatestMeta(): Meta
    @Query("SELECT * FROM meta WHERE interviewId =:id")
    fun getMetaForInterview(id: Int): Meta
}