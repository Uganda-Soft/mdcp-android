package com.cresonnglobal.mdcp.data.question


import androidx.annotation.NonNull
import androidx.room.*

@Entity(tableName = "meta")
data class Meta(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @NonNull
    var interviewId: Int,
    var note: String
) {
    @Ignore
    lateinit var basic_info: List<BasicInfo>
    constructor(
        id: Int,
        interviewId: Int,
        note: String,
        basic_info: List<BasicInfo>
    ) : this(id, interviewId, note) {
        this.basic_info = basic_info
    }
}