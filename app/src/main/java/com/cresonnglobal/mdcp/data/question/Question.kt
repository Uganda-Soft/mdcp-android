package com.cresonnglobal.mdcp.data.question

data class Question(
    var type_name: QuestionType,
    var name: String,
    var label: String,
    var hint: String,
    var default: String,
    var appearance: String,
    var constraint: Array<String>,
    var constraint_message: Array<String>,
    var relevance: String,
    var disabled: String,
    var required: String,
    var required_message: Array<String>,
    var read_only: String,
    var calculation: String,
    var repeat_count: String,
    var media: Media,
    var choice_filter: String,
    var note: String,
    var response_note: String,
    var publishable: String,
    var minimum_seconds: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Question) return false

        if (type_name != other.type_name) return false
        if (name != other.name) return false
        if (label != other.label) return false
        if (hint != other.hint) return false
        if (default != other.default) return false
        if (appearance != other.appearance) return false
        if (!constraint.contentEquals(other.constraint)) return false
        if (!constraint_message.contentEquals(other.constraint_message)) return false
        if (relevance != other.relevance) return false
        if (disabled != other.disabled) return false
        if (required != other.required) return false
        if (!required_message.contentEquals(other.required_message)) return false
        if (read_only != other.read_only) return false
        if (calculation != other.calculation) return false
        if (repeat_count != other.repeat_count) return false
        if (media != other.media) return false
        if (choice_filter != other.choice_filter) return false
        if (note != other.note) return false
        if (response_note != other.response_note) return false
        if (publishable != other.publishable) return false
        if (minimum_seconds != other.minimum_seconds) return false

        return true
    }

    override fun hashCode(): Int {
        var result = type_name.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + label.hashCode()
        result = 31 * result + hint.hashCode()
        result = 31 * result + default.hashCode()
        result = 31 * result + appearance.hashCode()
        result = 31 * result + constraint.contentHashCode()
        result = 31 * result + constraint_message.contentHashCode()
        result = 31 * result + relevance.hashCode()
        result = 31 * result + disabled.hashCode()
        result = 31 * result + required.hashCode()
        result = 31 * result + required_message.contentHashCode()
        result = 31 * result + read_only.hashCode()
        result = 31 * result + calculation.hashCode()
        result = 31 * result + repeat_count.hashCode()
        result = 31 * result + media.hashCode()
        result = 31 * result + choice_filter.hashCode()
        result = 31 * result + note.hashCode()
        result = 31 * result + response_note.hashCode()
        result = 31 * result + publishable.hashCode()
        result = 31 * result + minimum_seconds.hashCode()
        return result
    }
}