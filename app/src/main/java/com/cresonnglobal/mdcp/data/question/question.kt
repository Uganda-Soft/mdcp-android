package com.cresonnglobal.mdcp.data.question

data class Question(
    var type_name: QuestionType,
    var name: String,
    var label: String,
    var hint: String,
    var default: String,
    var appearance: String,
    var constraint: String,
    var constraint_message: String,
    var relevance: String,
    var disabled: String,
    var required: String,
    var required_message: String,
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