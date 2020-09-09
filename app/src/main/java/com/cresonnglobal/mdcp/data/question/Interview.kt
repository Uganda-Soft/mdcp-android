package com.cresonnglobal.mdcp.data.question

import androidx.room.*

@Entity(tableName = "interview")
data class Interview(
    @PrimaryKey(autoGenerate = true) val id: Int
)