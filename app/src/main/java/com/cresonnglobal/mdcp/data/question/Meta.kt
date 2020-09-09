package com.cresonnglobal.mdcp.data.question


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "meta")
data class Meta(
    @PrimaryKey(autoGenerate = true) val id: Int,
    var note: String
)