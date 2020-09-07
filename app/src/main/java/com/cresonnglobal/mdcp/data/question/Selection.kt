package com.cresonnglobal.mdcp.data.question

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "selection")
data class Selection(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val description: String
)