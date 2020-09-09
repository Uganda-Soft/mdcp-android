package com.cresonnglobal.mdcp.data.question

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "basic_info")
data class BasicInfo(
    @PrimaryKey(autoGenerate = true) val id: Int,
    var metaId: Int,
    var type: String,
    var name: String,
    var value: String
)