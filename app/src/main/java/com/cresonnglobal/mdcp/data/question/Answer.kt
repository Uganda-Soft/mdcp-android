package com.cresonnglobal.mdcp.data.question

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "answer")
data class Answer(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    var message: String,
    var date: String,
    var time: String,
    var duration: String,
    var logitude: Long,
    var latitude: Long
)