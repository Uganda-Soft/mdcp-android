package com.cresonnglobal.mdcp.data.question

import android.os.Parcel
import android.os.Parcelable
import androidx.room.*

@Entity(tableName = "question_types")
data class Type(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var type: String,
    var from: String
)

data class TypeSection(
    @Embedded val type: Type,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    ) val selections: List<Selection>
)