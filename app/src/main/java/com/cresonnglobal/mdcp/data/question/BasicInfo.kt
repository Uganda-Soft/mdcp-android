package com.cresonnglobal.mdcp.data.question

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity

@Entity(tableName = "basic_info")
data class BasicInfo(
    val type: String,
    val name: String,
    val value: String
)