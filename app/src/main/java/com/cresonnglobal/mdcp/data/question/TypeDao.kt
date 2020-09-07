package com.cresonnglobal.mdcp.data.question

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TypeDao {
    @Insert
    fun insertType(type: Type)

    @Query("SELECT * FROM question_types")
    fun queryTypes(): LiveData<List<Type>>
}