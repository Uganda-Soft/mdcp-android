package com.cresonnglobal.mdcp.data.question

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "selection")
data class Option(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @NonNull
    var typeId: Int,
    val name: String,
    val description: String
)