package com.cresonnglobal.mdcp.data.question

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "constraint_message")
data class ConstraintMessage(
    @PrimaryKey(autoGenerate = true) val id: Int,
    var questionId: Int,
    val message: String
)