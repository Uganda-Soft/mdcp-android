package com.cresonnglobal.mdcp.data.question

import androidx.room.*

@Entity(tableName = "interview")
data class Interview(
    var created: String,
    var author: String,
    var company: String,
    var title: String,
    var dateline: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    @Ignore
    lateinit var meta: Meta
    @Ignore
    lateinit var questions: List<Question>
    @Ignore
    constructor(
        created: String,
        author: String,
        company: String,
        title: String,
        dateline: String,
        meta: Meta,
        questions: List<Question>
    ) : this(
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