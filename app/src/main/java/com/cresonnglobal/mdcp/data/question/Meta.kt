package com.cresonnglobal.mdcp.data.question

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity

@Entity()
data class Meta(
    var note: String,
    var basic_info: List<BasicInfo>,
    var constraint_message: List<String>
)