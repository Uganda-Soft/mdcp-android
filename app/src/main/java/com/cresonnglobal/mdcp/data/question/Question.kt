package com.cresonnglobal.mdcp.data.question

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.*
import java.util.*

@Entity(tableName = "question")
data class Question(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @NonNull
    var typeId: Int,
    @Ignore
    var type_name: List<Type>?,
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
    var minimum_seconds: String,
    @Ignore
    var constraint_messages: List<ConstraintMessage>?,
    @Ignore
    var constraints: List<Constraint>?,
    var required_message: List<RequiredMessage>?
)