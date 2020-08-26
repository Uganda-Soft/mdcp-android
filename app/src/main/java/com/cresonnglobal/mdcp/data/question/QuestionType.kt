package com.cresonnglobal.mdcp.data.question

import android.os.Parcel
import android.os.Parcelable

data class QuestionType(
    var type: String?,
    var from: String?,
    var selections: List<String>?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeString(from)
        parcel.writeStringList(selections)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<QuestionType> {
        override fun createFromParcel(parcel: Parcel): QuestionType {
            return QuestionType(parcel)
        }

        override fun newArray(size: Int): Array<QuestionType?> {
            return arrayOfNulls(size)
        }
    }

}