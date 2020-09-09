package com.cresonnglobal.mdcp.data.question

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "require_message")
data class RequiredMessage(
    @NonNull
    var questionId: Int,
    val message: String
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}