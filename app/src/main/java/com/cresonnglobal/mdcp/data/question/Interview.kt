package com.cresonnglobal.mdcp.data.question

import androidx.room.*

@Entity(tableName = "interview")
data class Interview(
    @PrimaryKey(autoGenerate = true) val id: Int
)

data class InterviewMeta(
    @Embedded val interview: Interview,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    ) val meta: Meta
)


data class InterviewQuestion(
    @Embedded val interview: Interview,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    ) val Questions: List<Question>
)