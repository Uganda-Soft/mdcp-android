package com.cresonnglobal.mdcp.data.question

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "answer")
data class Answer(
    var questionId: Int,
    var body: String,
    var date: String,
    var time: String,
    var duration: String,
    var logitude: String,
    var latitude: String
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}