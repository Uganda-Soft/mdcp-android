package com.cresonnglobal.mdcp.data.question

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "constraint_message")
data class ConstraintMessage(
    var questionId: Int,
    val message: String
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}