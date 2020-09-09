package com.cresonnglobal.mdcp.common

import android.content.Context
import com.cresonnglobal.mdcp.data.question.Interview
import com.cresonnglobal.mdcp.data.question.MDCPQuestion

fun startActivityForType(
    MDCPQuestion: MDCPQuestion,
    context: Context,
    interview: Interview,
    number: Int
) {
//    val questions = interview.questions
//    when (question.type_name?.type) {
//        "audio" -> {
//            val intent = Intent(context, AudioActivity::class.java)
////            intent.putExtra(AudioActivity.QUESTION, question)
//            context.startActivity(intent)
//            return
//        }
//        "boolean" -> {
//            val intent = Intent(context, BooleanActivity::class.java)
////            intent.putExtra(BooleanActivity.QUESTION, question)
////            intent.putExtra(BooleanActivity.NEXT_QUESTION, getNextQuestion(number, questions))
////            intent.putExtra(BooleanActivity.PREVIOUS_QUESTION, getPreviousQuestion(number, questions))
//            context.startActivity(intent)
//            return
//        }
//        "number" -> {
//            val intent = Intent(context, NumberActivity::class.java)
////            intent.putExtra(NumberActivity.QUESTION, question)
//            context.startActivity(intent)
//            return
//        }
//        "textarea" -> {
//            val intent = Intent(context, TextAreaActivity::class.java)
////            intent.putExtra(TextAreaActivity.QUESTION, question)
//            context.startActivity(intent)
//            return
//        }
//        "video" -> {
//            val intent = Intent(context, VideoActivity::class.java)
////            intent.putExtra(VideoActivity.QUESTION, question)
//            context.startActivity(intent)
//            return
//        }
//        "decimal" -> {
//            val intent = Intent(context, DecimalActivity::class.java)
////            intent.putExtra(DecimalActivity.QUESTION, question)
//            context.startActivity(intent)
//            return
//        }
//        "image" -> {
//            val intent = Intent(context, PhotoActivity::class.java)
////            intent.putExtra(PhotoActivity.QUESTION, question)
//            context.startActivity(intent)
//            return
//        }
//        "date" -> {
//            val intent = Intent(context, DateActivity::class.java)
////            intent.putExtra(DateActivity.QUESTION, question)
//            context.startActivity(intent)
//            return
//        }
//        "time" -> {
//            val intent = Intent(context, TimeActivity::class.java)
////            intent.putExtra(TimeActivity.QUESTION, question)
//            context.startActivity(intent)
//            return
//        }
//
//        "multiple_select" -> {
//            val intent = Intent(context, MultipleSelectionActivity::class.java)
////            intent.putExtra(MultipleSelectionActivity.QUESTION, question)
//            context.startActivity(intent)
//        }
//
//        "text" -> {
//            val intent = Intent(context, TextActivity::class.java)
////            intent.putExtra(TextActivity.QUESTION, question)
//            context.startActivity(intent)
//        }
//    }
}

fun getPreviousQuestion(number: Int, MDCPQuestions: List<MDCPQuestion>?): MDCPQuestion? {
    if (number <= 0) {
        return MDCPQuestions?.get(0)
    }
    return MDCPQuestions?.get(number)
}

fun getNextQuestion(currentQuestion: Int, MDCPQuestions: List<MDCPQuestion>?): MDCPQuestion? {
    if (currentQuestion <= 0) {
        return MDCPQuestions?.get(0)
    }

    if (MDCPQuestions != null) {
        if (currentQuestion >= MDCPQuestions.size) {
            return MDCPQuestions?.get(currentQuestion + 1)
        }
    }
    return MDCPQuestions?.get(currentQuestion)
}