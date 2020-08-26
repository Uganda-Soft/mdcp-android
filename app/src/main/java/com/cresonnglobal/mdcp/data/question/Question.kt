package com.cresonnglobal.mdcp.data.question

import android.os.Parcel
import android.os.Parcelable

data class Question(
    var type_name: QuestionType?,
    var name: String?,
    var label: String?,
    var hint: String?,
    var default: String?,
    var appearance: String?,
    var constraint: List<String>?,
    var constraint_message: Array<String>?,
    var relevance: String?,
    var disabled: String?,
    var required: String?,
    var required_message: Array<String>?,
    var read_only: String?,
    var calculation: String?,
    var repeat_count: String?,
    var media: Media?,
    var choice_filter: String?,
    var note: String?,
    var response_note: String?,
    var publishable: String?,
    var minimum_seconds: String?
) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(QuestionType::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.createStringArray(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArray(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(Media::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Question

        if (name != other.name) return false
        if (label != other.label) return false
        if (hint != other.hint) return false
        if (default != other.default) return false
        if (appearance != other.appearance) return false
        if (constraint != other.constraint) return false
        if (relevance != other.relevance) return false
        if (disabled != other.disabled) return false
        if (required != other.required) return false
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
        var result = name?.hashCode() ?: 0
        result = 31 * result + (label?.hashCode() ?: 0)
        result = 31 * result + (hint?.hashCode() ?: 0)
        result = 31 * result + (default?.hashCode() ?: 0)
        result = 31 * result + (appearance?.hashCode() ?: 0)
        result = 31 * result + (relevance?.hashCode() ?: 0)
        result = 31 * result + (disabled?.hashCode() ?: 0)
        result = 31 * result + (required?.hashCode() ?: 0)
        result = 31 * result + (read_only?.hashCode() ?: 0)
        result = 31 * result + (calculation?.hashCode() ?: 0)
        result = 31 * result + (repeat_count?.hashCode() ?: 0)
        result = 31 * result + (media?.hashCode() ?: 0)
        result = 31 * result + (choice_filter?.hashCode() ?: 0)
        result = 31 * result + (note?.hashCode() ?: 0)
        result = 31 * result + (response_note?.hashCode() ?: 0)
        result = 31 * result + (publishable?.hashCode() ?: 0)
        result = 31 * result + (minimum_seconds?.hashCode() ?: 0)
        return result
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(type_name, flags)
        parcel.writeString(name)
        parcel.writeString(label)
        parcel.writeString(hint)
        parcel.writeString(default)
        parcel.writeString(appearance)
        parcel.writeStringList(constraint)
        parcel.writeStringArray(constraint_message)
        parcel.writeString(relevance)
        parcel.writeString(disabled)
        parcel.writeString(required)
        parcel.writeStringArray(required_message)
        parcel.writeString(read_only)
        parcel.writeString(calculation)
        parcel.writeString(repeat_count)
        parcel.writeParcelable(media, flags)
        parcel.writeString(choice_filter)
        parcel.writeString(note)
        parcel.writeString(response_note)
        parcel.writeString(publishable)
        parcel.writeString(minimum_seconds)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Question> {
        override fun createFromParcel(parcel: Parcel): Question {
            return Question(parcel)
        }

        override fun newArray(size: Int): Array<Question?> {
            return arrayOfNulls(size)
        }
    }


}