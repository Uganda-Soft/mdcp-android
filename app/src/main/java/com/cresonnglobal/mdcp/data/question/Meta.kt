package com.cresonnglobal.mdcp.data.question


import androidx.room.*

@Entity(tableName = "meta")
data class Meta(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var note: String
) {
    lateinit var basic_info: List<BasicInfo>
    constructor(
        id: Int,
        note: String,
        basic_info: List<BasicInfo>
    ) : this(id, note) {
        this.basic_info = basic_info
    }
}