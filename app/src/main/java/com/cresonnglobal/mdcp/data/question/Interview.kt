package com.cresonnglobal.mdcp.data.question

data class Interview(
    val meta: List<BasicInfo>,
    val questions: List<Question>
) {
}