package com.cresonnglobal.mdcp.data.question


import androidx.annotation.NonNull
import androidx.room.*

@Entity(tableName = "meta")
data class Meta(
    @NonNull
    var interviewId: Int,
    var note: String
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
    @Ignore
    lateinit var basic_info: List<BasicInfo>
    constructor(
        interviewId: Int,
        note: String,
        basic_info: List<BasicInfo>
    ) : this(interviewId, note) {
        this.basic_info = basic_info
    }
}