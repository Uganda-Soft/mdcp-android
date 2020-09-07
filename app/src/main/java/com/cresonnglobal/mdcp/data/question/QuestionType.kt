package com.cresonnglobal.mdcp.data.question

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "question_types")
data class QuestionType(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var type: String,
    var from: String,
    var selections: List<String>
)