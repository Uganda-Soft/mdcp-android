package com.cresonnglobal.mdcp.data.question

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface InterviewDao {
    @Insert
    fun insertInterview(interview: Interview)

    @Query("SELECT * FROM interview ORDER BY id DESC LIMIT 1")
    fun getLatestInterview(): Interview
}