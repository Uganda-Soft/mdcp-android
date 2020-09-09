package com.cresonnglobal.mdcp.dev

import android.util.Log
import com.cresonnglobal.mdcp.Repository
import com.cresonnglobal.mdcp.data.question.BasicInfo
import com.cresonnglobal.mdcp.data.question.Interview
import com.cresonnglobal.mdcp.data.question.Meta

class Seeder(private val repository: Repository) {
    fun seedInterview() {
        var interview = Interview(
            created = "12-09-2020",
            author = "Simon Peter Ojok",
            company = "Uganda Soft",
            title = "App Development Status Investigation",
            dateline = "30-12-2020"
        )

        interview = repository.insertInterview(interview)
        var meta = Meta(
            interviewId = interview.id,
            note = "This Question was seeded by the database"
        )

        meta = repository.insertMeta(meta)
        var basic_info = BasicInfo(
            metaId = meta.id,
            type = "Time",
            name = "Duration",
            value = "8Hours"
        )

        meta.basic_info = repository.insertBasicInfo(basic_info)

    }
}