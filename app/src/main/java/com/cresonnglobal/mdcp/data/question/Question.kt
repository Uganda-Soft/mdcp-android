package com.cresonnglobal.mdcp.data.question

import androidx.annotation.NonNull
import androidx.room.*

@Entity(tableName = "question")
data class Question(
    @NonNull
    var interviewId: Int,
    var name: String,
    var label: String,
    var hint: String,
    var default_value: String,
    var appearance: String,
    var relevance: String,
    var disabled: Boolean,
    var required: Boolean,
    var read_only: Boolean,
    var calculation: String,
    var repeat_count: Int,
    var choice_filter: String,
    var note: String,
    var response_note: String,
    var publishable: String,
    var minimum_seconds: Long
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
    @Ignore
    lateinit var constraint_messages: List<ConstraintMessage>
    @Ignore
    lateinit var constraints: List<Constraint>
    @Ignore
    lateinit var required_message: List<RequiredMessage>
    @Ignore
    lateinit var media: Media
    @Ignore
    lateinit var answers: List<Answer>
    @Ignore
    lateinit var type_name: List<Type>
//    @Ignore
//    constructor(
//        name: String,
//        label: String,
//        hint: String,
//        default_value: String,
//        appearance: String,
//        relevance: String,
//        disabled: Boolean,
//        required: String,
//        read_only: String,
//        calculation: String,
//        repeat_count: Int,
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
//        name,
//        label,
//        hint,
//        default_value,
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