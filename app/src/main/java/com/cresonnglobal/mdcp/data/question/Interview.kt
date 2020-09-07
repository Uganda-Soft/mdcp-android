package com.cresonnglobal.mdcp.data.question

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

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
    ) val questions: List<Question>
)