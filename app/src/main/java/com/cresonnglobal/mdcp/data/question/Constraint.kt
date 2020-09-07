package com.cresonnglobal.mdcp.data.question

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "constraints")
data class Constraint(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val expression: String
)