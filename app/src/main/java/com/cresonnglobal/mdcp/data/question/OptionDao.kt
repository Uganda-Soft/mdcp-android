package com.cresonnglobal.mdcp.data.question

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface OptionDao {
    @Insert
    fun insertSelection(selection: Option)

    @Query("SELECT * FROM selection")
    fun querySelections(): LiveData<List<Option>>
}