package com.cresonnglobal.mdcp.data.question

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AnswerDao {
    @Insert
    fun insertAnswer(answer: Answer)

    @Query(
        "SELECT * FROM answer"
    )
    fun queryAnswers(): LiveData<List<Answer>>
}