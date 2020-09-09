package com.cresonnglobal.mdcp.dev

import com.cresonnglobal.mdcp.Repository
import com.cresonnglobal.mdcp.data.question.Interview

class Seeder(val repository: Repository) {
    fun seedInterview() {
        val interview = Interview(
            id = null,
            created = "12-09-2020",
            author = "Simon Peter Ojok",
            company = "Uganda Soft",
            title = "App Development Status Investigation",
            dateline = "30-12-2020"
        )

        repository.insertInterview(interview)
    }
}