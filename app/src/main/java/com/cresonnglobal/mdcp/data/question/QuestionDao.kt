package com.cresonnglobal.mdcp.data.question

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuestionDao {
    @Insert
    fun insertQuestion(Question: Question)

    @Query("SELECT * FROM question")
    fun queryQuestion(): List<Question>

    @Query("SELECT * FROM question ORDER BY id DESC LIMIT 1")
    fun getLatestQuestion(): Question
    fun getQuestionForInterview(id: Int): List<Question>

//    @Transaction
//    @Query("SELECT * FROM question")
//    fun queryQuestionType(): List<QuestionType>

}