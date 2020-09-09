package com.cresonnglobal.mdcp.dev

import com.cresonnglobal.mdcp.Repository
import com.cresonnglobal.mdcp.data.question.BasicInfo
import com.cresonnglobal.mdcp.data.question.Interview
import com.cresonnglobal.mdcp.data.question.Meta
import com.cresonnglobal.mdcp.data.question.Question

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
        val basic_info = BasicInfo(
            metaId = meta.id,
            type = "Time",
            name = "Duration",
            value = "8Hours"
        )

        meta.basic_info = repository.insertBasicInfo(basic_info)
        meta.basic_info = repository.insertBasicInfo(basic_info)
        meta.basic_info = repository.insertBasicInfo(basic_info)
        meta.basic_info = repository.insertBasicInfo(basic_info)
        meta.basic_info = repository.insertBasicInfo(basic_info)

        interview.meta = meta

        // question
        var question1 = Question(
            name = "Which Technology was used to Build This Mobile Application?",
            label = "Q1A",
            hint = "Ask Developers who made this mobile application",
            default_value = "",
            appearance = "TEXT",
            relevance = "NONE",
            disabled = false,
            required = true,
            read_only = false,
            calculation = "",
            repeat_count = 4,
            choice_filter = "None",
            note = "Please request this information from the developers and ask them",
            response_note = "List the answers in the box below",
            publishable = "False",
            minimum_seconds = 787
        )

    }
}