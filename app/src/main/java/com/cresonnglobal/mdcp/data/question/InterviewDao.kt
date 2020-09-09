package com.cresonnglobal.mdcp.data.question

import androidx.room.Dao
import androidx.room.Insert
@Dao
interface InterviewDao {
    @Insert
    fun insertInterview(interview: Interview)
}