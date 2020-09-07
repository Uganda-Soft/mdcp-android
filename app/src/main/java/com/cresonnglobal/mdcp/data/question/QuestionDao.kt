package com.cresonnglobal.mdcp.data.question

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface QuestionDao {
    @Insert
    fun insertQuestion(question: Question)

    @Query("SELECT * FROM question")
    fun queryQuestion(): List<Question>

//    @Transaction
//    @Query("SELECT * FROM question")
//    fun queryQuestionType(): List<QuestionType>

}