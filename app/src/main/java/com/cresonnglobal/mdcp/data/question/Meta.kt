package com.cresonnglobal.mdcp.data.question

import android.os.Parcel
import android.os.Parcelable

data class Meta(
    var note: String?,
    var basic_info: Array<BasicInfo>?,
    var constraint_message: Array<String>?
): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.createTypedArray(BasicInfo),
        parcel.createStringArray()
    ) {
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Meta

        if (note != other.note) return false
        if (basic_info != null) {
            if (other.basic_info == null) return false
            if (!basic_info!!.contentEquals(other.basic_info!!)) return false
        } else if (other.basic_info != null) return false
        if (constraint_message != null) {
            if (other.constraint_message == null) return false
            if (!constraint_message!!.contentEquals(other.constraint_message!!)) return false
        } else if (other.constraint_message != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = note?.hashCode() ?: 0
        result = 31 * result + (basic_info?.contentHashCode() ?: 0)
        result = 31 * result + (constraint_message?.contentHashCode() ?: 0)
        return result
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(note)
        parcel.writeTypedArray(basic_info, flags)
        parcel.writeStringArray(constraint_message)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Meta> {
        override fun createFromParcel(parcel: Parcel): Meta {
            return Meta(parcel)
        }

        override fun newArray(size: Int): Array<Meta?> {
            return arrayOfNulls(size)
        }
    }


}