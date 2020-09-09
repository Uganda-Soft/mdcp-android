package com.cresonnglobal.mdcp.data.question


import androidx.room.*

@Entity(tableName = "meta")
data class Meta(
    @PrimaryKey(autoGenerate = true) val id: Int,
    var note: String,
    @Ignore
    var basic_info: List<BasicInfo>?
)