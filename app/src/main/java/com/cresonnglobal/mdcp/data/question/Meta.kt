package com.cresonnglobal.mdcp.data.question


import androidx.room.*

@Entity(tableName = "meta")
data class Meta(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var note: String
) {
    constructor(
        id: Int,
        note: String,
        basic_info: List<BasicInfo>
    ) : this(id, note)
}