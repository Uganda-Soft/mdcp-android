package com.cresonnglobal.mdcp.data.question

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ConstraintMessageDao {
    @Insert
    fun insertConstraintMessage(constraintMessage: ConstraintMessage)

    @Query("SELECT * FROM constraint_message")
    fun queryConstraintsMessage(): LiveData<List<ConstraintMessage>>

    @Query("SELECT * FROM constraint_message WHERE questionId =:questionId")
    fun getConstraintMessageForQuestion(questionId: Int): List<ConstraintMessage>
}