package com.cresonnglobal.mdcp.data.question

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BasicInfoDao {
    @Insert
    fun insertBasicInfo(basicInfoDao: BasicInfoDao)

    @Query("SELECT * FROM basic_info")
    fun queryBasicInfo(): LiveData<List<BasicInfo>>
}