package com.cresonnglobal.mdcp.data.question

import androidx.room.*

@Entity(tableName = "question_types")
data class Type(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var type: String,
    var from: String,
    var rangeId: Int
) {
    @Ignore
    constructor(
        id: Int,
        options: List<Option>?,
        range: Range?,
        type: String,
        from: String,
        rangeId: Int
    ) : this(id, type, from, rangeId)
}