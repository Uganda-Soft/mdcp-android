package com.cresonnglobal.mdcp.dev

import android.util.Log
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

        for ( i in 1..50) {
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

            if (i == 1) {
                var type = Type(
                    questionId = question1.id,
                    type = "Audio",
                    from = ""
                )

                type = repository.insertType(type)
                var range = Range(
                    typeId = type.id,
                    max = 500,
                    min = 60
                )

                range = repository.insertRange(range)
                type.range = range
                question1.type = type
            } else if (i == 2 ) {
                var type = Type(
                    questionId = question1.id,
                    type = "Boolean",
                    from = ""
                )

                type = repository.insertType(type)
                var range = Range(
                    typeId = type.id,
                    max = 500,
                    min = 60
                )

                range = repository.insertRange(range)
                type.range = range
                question1.type = type
            } else if (i == 3) {
                var type = Type(
                    questionId = question1.id,
                    type = "Decimal",
                    from = ""
                )

                type = repository.insertType(type)
                var range = Range(
                    typeId = type.id,
                    max = 500,
                    min = 60
                )

                range = repository.insertRange(range)
                type.range = range
                question1.type = type
            } else if (i == 4) {
                var type = Type(
                    questionId = question1.id,
                    type = "Date",
                    from = ""
                )

                type = repository.insertType(type)
                var range = Range(
                    typeId = type.id,
                    max = 500,
                    min = 60
                )

                range = repository.insertRange(range)
                type.range = range
                question1.type = type
            } else if (i == 5) {
                var type = Type(
                    questionId = question1.id,
                    type = "Number",
                    from = ""
                )

                type = repository.insertType(type)
                var range = Range(
                    typeId = type.id,
                    max = 500,
                    min = 60
                )

                range = repository.insertRange(range)
                type.range = range
                question1.type = type
            } else if (i == 6) {
                var type = Type(
                    questionId = question1.id,
                    type = "Photo",
                    from = ""
                )

                type = repository.insertType(type)
                var range = Range(
                    typeId = type.id,
                    max = 500,
                    min = 60
                )

                range = repository.insertRange(range)
                type.range = range
                question1.type = type
            } else if (i == 7) {
                var type = Type(
                    questionId = question1.id,
                    type = "Select",
                    from = ""
                )

                type = repository.insertType(type)
                var range = Range(
                    typeId = type.id,
                    max = 500,
                    min = 60
                )

                range = repository.insertRange(range)
                type.range = range
                question1.type = type
            } else if (i == 8) {
                var type = Type(
                    questionId = question1.id,
                    type = "Text",
                    from = ""
                )

                type = repository.insertType(type)
                var range = Range(
                    typeId = type.id,
                    max = 500,
                    min = 60
                )

                range = repository.insertRange(range)
                type.range = range
                question1.type = type
            } else if (i == 9) {
                var type = Type(
                    questionId = question1.id,
                    type = "Textarea",
                    from = ""
                )

                type = repository.insertType(type)
                var range = Range(
                    typeId = type.id,
                    max = 500,
                    min = 60
                )

                range = repository.insertRange(range)
                type.range = range
                question1.type = type
            } else if (i == 10) {
                var type = Type(
                    questionId = question1.id,
                    type = "Time",
                    from = ""
                )

                type = repository.insertType(type)
                var range = Range(
                    typeId = type.id,
                    max = 500,
                    min = 60
                )

                range = repository.insertRange(range)
                type.range = range
                question1.type = type
            } else if (i == 11) {
                var type = Type(
                    questionId = question1.id,
                    type = "Video",
                    from = ""
                )

                type = repository.insertType(type)
                var range = Range(
                    typeId = type.id,
                    max = 500,
                    min = 60
                )

                range = repository.insertRange(range)
                type.range = range
                question1.type = type
            } else {
                var type = Type(
                    questionId = question1.id,
                    type = "Video",
                    from = ""
                )

                type = repository.insertType(type)
                var range = Range(
                    typeId = type.id,
                    max = 500,
                    min = 60
                )

                range = repository.insertRange(range)
                type.range = range
                question1.type = type
            }

            var answer = Answer(
                questionId = question1.id,
                time = "09:40am",
                body = "The List",
                duration = "67min",
                latitude = "89746663645535546",
                logitude = "8988477474",
                date = "07-08-2020"

            )

            question1.answers = repository.insertAnswer(answer)
            question1.answers = repository.insertAnswer(answer)
            question1.answers = repository.insertAnswer(answer)
            question1.answers = repository.insertAnswer(answer)
            question1.answers = repository.insertAnswer(answer)

            Log.d("SEEDER", question1.toString())
        }
    }
}