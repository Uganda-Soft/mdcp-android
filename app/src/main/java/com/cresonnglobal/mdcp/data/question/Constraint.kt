package com.cresonnglobal.mdcp.data.question

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "constraints")
data class Constraint(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @NonNull
    var questionId: Int,
    @Ignore
    var constraints: List<Constraint>?,
    val expression: String
)