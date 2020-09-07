package com.cresonnglobal.mdcp.data.question

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "require_message")
data class RequiredMessage(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val message: String
)