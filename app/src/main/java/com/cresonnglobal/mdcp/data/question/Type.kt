package com.cresonnglobal.mdcp.data.question

import androidx.annotation.NonNull
import androidx.room.*

@Entity(tableName = "question_types")
data class Type(
    @NonNull
    var questionId: Int,
    var type: String,
    var from: String
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
    @Ignore lateinit var range: Range
//    @Ignore
//    constructor(
//        id: Int,
//        questionId: Int,
//        options: List<Option>?,
//        range: Range?,
//        type: String,
//        from: String,
//        rangeId: Int
//    ) : this(id, questionId, type, from, rangeId)
}