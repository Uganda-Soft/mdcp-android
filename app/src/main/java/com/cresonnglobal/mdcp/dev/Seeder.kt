package com.cresonnglobal.mdcp.dev

import com.cresonnglobal.mdcp.Repository
import com.cresonnglobal.mdcp.data.question.*

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
            interviewId = interview.id,
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

        question1 = repository.insertQuestion(question1)

        // question 1, constraint_messages
        var constraintMessage = ConstraintMessage(
            questionId = question1.id,
            message = "This Question Is required for you to answer the second question"
        )
        question1.constraint_messages = repository.insertConstraintMessage(constraintMessage)
        // question 1, constraint_messages
        constraintMessage = ConstraintMessage(
            questionId = question1.id,
            message = "This Question Is required for you to answer the second question"
        )
        question1.constraint_messages = repository.insertConstraintMessage(constraintMessage)
        // question 1, constraint_messages
        constraintMessage = ConstraintMessage(
            questionId = question1.id,
            message = "This Question Is required for you to answer the second question"
        )
        question1.constraint_messages = repository.insertConstraintMessage(constraintMessage)
        constraintMessage = ConstraintMessage(
            questionId = question1.id,
            message = "This Question Is required for you to answer the second question"
        )
        question1.constraint_messages = repository.insertConstraintMessage(constraintMessage)

//        question contraint
        var constraint = Constraint(
            questionId = question1.id,
            value = 89,
            operator = "<="
        )
        question1.constraints = repository.insertConstraint(constraint)

        constraint = Constraint(
            questionId = question1.id,
            value = 89,
            operator = "<="
        )
        question1.constraints = repository.insertConstraint(constraint)
        constraint = Constraint(
            questionId = question1.id,
            value = 89,
            operator = "<="
        )
        question1.constraints = repository.insertConstraint(constraint)
        constraint = Constraint(
            questionId = question1.id,
            value = 89,
            operator = "<="
        )
        question1.constraints = repository.insertConstraint(constraint)

        // required message
        var requiredMessage = RequiredMessage(
            questionId = question1.id,
            message = "Please on provide approved figures"
        )

        question1.required_message = repository.insertRequiredMessage(requiredMessage)

        requiredMessage = RequiredMessage(
            questionId = question1.id,
            message = "Please on provide approved figures"
        )

        question1.required_message = repository.insertRequiredMessage(requiredMessage)

        requiredMessage = RequiredMessage(
            questionId = question1.id,
            message = "Please on provide approved figures"
        )

        question1.required_message = repository.insertRequiredMessage(requiredMessage)
        requiredMessage = RequiredMessage(
            questionId = question1.id,
            message = "Please on provide approved figures"
        )

        question1.required_message = repository.insertRequiredMessage(requiredMessage)
        requiredMessage = RequiredMessage(
            questionId = question1.id,
            message = "Please on provide approved figures"
        )

        question1.required_message = repository.insertRequiredMessage(requiredMessage)
        requiredMessage = RequiredMessage(
            questionId = question1.id,
            message = "Please on provide approved figures"
        )

        question1.required_message = repository.insertRequiredMessage(requiredMessage)

        var media = Media(
            questionId = question1.id,
            videoURL = "tyyryyryryryyryr",
            audioURL = "ttrtrtryyryryryryyr"
        )

        question1.media = repository.insertMedia(media)
    }
}