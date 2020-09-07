package com.cresonnglobal.mdcp.data.question

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "question")
data class Question(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var type_name: QuestionType,
    var name: String,
    var label: String,
    var hint: String,
    var default: String,
    var appearance: String,
    var constraint: List<String>,
    var constraint_message: List<String>,
    var relevance: String,
    var disabled: String,
    var required: String,
    var required_message: List<String>,
    var read_only: String,
    var calculation: String,
    var repeat_count: String,
    var media: Media,
    var choice_filter: String,
    var note: String,
    var response_note: String,
    var publishable: String,
    var minimum_seconds: String
)