package com.cresonnglobal.mdcp.data.question

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "media")
data class Media (
    @NonNull
    var questionId: Int,
    val videoURL: String,
    val audioURL: String
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}