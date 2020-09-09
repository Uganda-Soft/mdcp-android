package com.cresonnglobal.mdcp.data.question

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "constraints")
data class Constraint(
    @NonNull
    var questionId: Int,
    var value: Int,
    var operator: String
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}