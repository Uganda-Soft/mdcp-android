package com.cresonnglobal.mdcp.data.question

import androidx.room.*

@Entity(tableName = "interview")
data class Interview(
    @PrimaryKey(autoGenerate = true) val id: Int,
    var created: String,
    var author: String,
    var company: String,
    var title: String,
    var dateline: String
) {
    constructor(
        id: Int,
        created: String,
        author: String,
        company: String,
        title: String,
        dateline: String,
        meta: Meta
    ) : this(
        id,
        created,
        author,
        company,
        title,
        dateline
    )
}