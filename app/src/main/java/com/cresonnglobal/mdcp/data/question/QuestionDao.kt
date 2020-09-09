package com.cresonnglobal.mdcp.data.question

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuestionDao {
    @Insert
    fun insertQuestion(MDCPQuestion: MDCPQuestion)

    @Query("SELECT * FROM question")
    fun queryQuestion(): List<MDCPQuestion>

//    @Transaction
//    @Query("SELECT * FROM question")
//    fun queryQuestionType(): List<QuestionType>

}