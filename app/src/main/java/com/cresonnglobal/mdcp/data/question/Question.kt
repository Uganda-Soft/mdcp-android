package com.cresonnglobal.mdcp.data.question

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.util.*

@Entity(tableName = "question")
data class Question(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val label: String,
    val hint: String,
    val default: String,
    val appearance: String,
    val constraint: List<String>,
    val relevance: String,
    val disabled: String,
    val required: String,
    val read_only: String,
    val calculation: String,
    val repeat_count: String,
    val media: Media,
    val choice_filter: String,
    val note: String,
    val response_note: String,
    val publishable: String,
    val minimum_seconds: String
)

data class QuestionType(
    @Embedded val question: Question,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    ) val type: Type
)

data class QuestionRequireMessage(
    @Embedded val question: Question,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    ) val required_messages: List<RequiredMessage>
)

data class QuestionConstraintMessage(
    @Embedded val question: Question,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    ) val constraint_messages: List<ConstraintMessage>
)