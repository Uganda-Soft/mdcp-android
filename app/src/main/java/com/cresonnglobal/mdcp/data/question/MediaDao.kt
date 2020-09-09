package com.cresonnglobal.mdcp.data.question

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MediaDao {
    @Insert
    fun insertMedia(media: Media)

    @Query("SELECT * FROM media")
    fun queryMedia(): LiveData<List<Media>>

    @Query("SELECT * FROM media WHERE questionId =:questionId")
    fun getMediaForQuestion(questionId: Int): List<Media>
}