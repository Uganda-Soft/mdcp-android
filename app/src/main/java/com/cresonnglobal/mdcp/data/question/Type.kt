package com.cresonnglobal.mdcp.data.question

import androidx.room.*

@Entity(tableName = "question_types")
data class Type(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @Ignore
    var options: List<Option>?,
    @Ignore
    var range: Range?,
    var type: String,
    var from: String,
    var rangeId: Int
)