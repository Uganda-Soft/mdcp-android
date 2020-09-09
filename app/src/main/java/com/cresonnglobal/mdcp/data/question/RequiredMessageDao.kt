package com.cresonnglobal.mdcp.data.question

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RequiredMessageDao {
    @Insert
    fun insertRequiredMessage(requiredMessage: RequiredMessage)

    @Query("SELECT * FROM require_message")
    fun queryRequiredMessage(): LiveData<List<RequiredMessage>>

    @Query("SELECT * FROM require_message WHERE questionId =:questionId")
    fun getRequiredMessageForQuestion(questionId: Int): List<RequiredMessage>
}