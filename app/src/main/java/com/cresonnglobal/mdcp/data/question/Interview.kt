package com.cresonnglobal.mdcp.data.question

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "interview")
data class Interview(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val meta: Meta,
    val questions: List<Question>
)

data class InterviewMeta(
    @Embedded val interview: Interview,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    ) val meta: Meta
)