package com.cresonnglobal.mdcp.data.question

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BasicInfoDao {
    @Insert
    fun insertBasicInfo(basicInfoDao: BasicInfo)

    @Query("SELECT * FROM basic_info")
    fun queryBasicInfo(): LiveData<List<BasicInfo>>

    @Query("SELECT * FROM basic_info WHERE metaId =:metaId")
    fun getBasicInfoForMeta(metaId: Int): List<BasicInfo>
}