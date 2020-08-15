package com.cresonnglobal.mdcp.data.question

data class Interview(
    val meta: Array<Meta>,
    val questions: Array<Question>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Interview) return false

        if (!meta.contentEquals(other.meta)) return false

        return true
    }

    override fun hashCode(): Int {
        return meta.contentHashCode()
    }
}