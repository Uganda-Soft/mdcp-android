package com.cresonnglobal.mdcp.data.question

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "media")
data class Media (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @NonNull
    var questionId: Int,
    val video: String,
    val audio: String
)