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
    @PrimaryKey(autoGenerate = true) var id: Int,
    var name: String,
    var label: String,
    var hint: String,
    var default: String,
    var appearance: String,
    var relevance: String,
    var disabled: String,
    var required: String,
    var read_only: String,
    var calculation: String,
    var repeat_count: String,
    var choice_filter: String,
    var note: String,
    var response_note: String,
    var publishable: String,
    var minimum_seconds: String
)