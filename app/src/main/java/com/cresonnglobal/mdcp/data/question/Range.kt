package com.cresonnglobal.mdcp.data.question

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "range")
data class Range(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var max: Int,
    var min: Int
)