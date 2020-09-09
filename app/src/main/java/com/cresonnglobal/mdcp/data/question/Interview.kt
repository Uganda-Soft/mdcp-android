package com.cresonnglobal.mdcp.data.question

import androidx.room.*

@Entity(tableName = "interview")
data class Interview(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    var created: String,
    var author: String,
    var company: String,
    var title: String,
    var dateline: String
) {
    @Ignore
    lateinit var meta: Meta
    @Ignore
    lateinit var questions: List<Question>
    @Ignore
    constructor(
        id: Int,
        created: String,
        author: String,
        company: String,
        title: String,
        dateline: String,
        meta: Meta,
        questions: List<Question>
    ) : this(
        id,
        created,
        author,
        company,
        title,
        dateline
    ) {
        this.questions = questions
        this.meta = meta
    }
}