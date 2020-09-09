package com.cresonnglobal.mdcp.data.question

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.*
import java.util.*
import kotlin.math.min

@Entity(tableName = "question")
data class Question(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var name: String,
    var label: String,
    var hint: String,
    var default_value: String,
    var appearance: String,
    var relevance: String,
    var disabled: Boolean,
    var required: String,
    var read_only: String,
    var calculation: String,
    var repeat_count: Int,
    var choice_filter: String,
    var note: String,
    var response_note: String,
    var publishable: String,
    var minimum_seconds: String
) {
//    @Ignore
//    constructor(
//        id: Int,
//        name: String,
//        label: String,
//        hint: String,
//        default: String,
//        appearance: String,
//        relevance: String,
//        disabled: String,
//        required: String,
//        read_only: String,
//        calculation: String,
//        repeat_count: String,
//        choice_filter: String,
//        note: String,
//        response_note: String,
//        publishable: String,
//        minimum_seconds: String,
//        constraint_messages: List<ConstraintMessage>,
//        constraints: List<Constraint>,
//        required_message: List<RequiredMessage>,
//        media: Media,
//        answers: List<Answer>,
//        type_name: List<Type>
//    ) : this(
//        id,
//        name,
//        label,
//        hint,
//        default,
//        appearance,
//        relevance,
//        disabled,
//        required,
//        read_only,
//        calculation,
//        repeat_count,
//        choice_filter,
//        note,
//        response_note,
//        publishable,
//        minimum_seconds
//    )
}