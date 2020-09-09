package com.cresonnglobal.mdcp.data.question

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "range")
data class Range(
    var typeId: Int,
    var max: Int,
    var min: Int
) {
    @PrimaryKey(autoGenerate = true)  var id: Int = 0
}