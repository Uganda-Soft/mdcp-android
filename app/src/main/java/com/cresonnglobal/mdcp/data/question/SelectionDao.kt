package com.cresonnglobal.mdcp.data.question

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SelectionDao {
    @Insert
    fun insertSelection(selection: Selection)

    @Query("SELECT * FROM selection")
    fun querySelections(): LiveData<List<Selection>>
}