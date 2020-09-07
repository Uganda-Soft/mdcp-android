package com.cresonnglobal.mdcp.data.question

import androidx.room.Query
import androidx.room.Transaction

interface InterviewDao {
    @Transaction
    @Query("SELECT * FROM interview")
    fun getInterviewMeta(): List<Meta>
}