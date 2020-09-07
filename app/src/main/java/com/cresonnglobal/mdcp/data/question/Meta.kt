package com.cresonnglobal.mdcp.data.question

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "meta")
data class Meta(
    @PrimaryKey(autoGenerate = true) val id: Int,
    var note: String,
    var constraint_message: List<String>
)

data class  MetaBasicInfo(
    @Embedded val meta: Meta,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    ) val basic_info: List<BasicInfo>
)

data class MetaConstrainMessage(
    @Embedded val meta: Meta,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    ) val constraint_message: List<String>
)