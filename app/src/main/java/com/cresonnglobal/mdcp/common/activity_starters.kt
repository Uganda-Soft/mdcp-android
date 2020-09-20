package com.cresonnglobal.mdcp.common

import android.content.Context
import android.content.Intent
import com.cresonnglobal.mdcp.audio.AudioActivity
import com.cresonnglobal.mdcp.booleans.BooleanActivity
import com.cresonnglobal.mdcp.data.question.Interview
import com.cresonnglobal.mdcp.data.question.Question
import com.cresonnglobal.mdcp.date.DateActivity
import com.cresonnglobal.mdcp.decimal.DecimalActivity
import com.cresonnglobal.mdcp.number.NumberActivity
import com.cresonnglobal.mdcp.photo.PhotoActivity
import com.cresonnglobal.mdcp.select.MultipleSelectionActivity
import com.cresonnglobal.mdcp.text.TextActivity
import com.cresonnglobal.mdcp.textarea.TextAreaActivity
import com.cresonnglobal.mdcp.time.TimeActivity
import com.cresonnglobal.mdcp.video.VideoActivity

fun startActivityForType(
    question: Question,
    context: Context,
    interview: Interview,
    number: Int
) {
    when (question.type.type) {
        "audio" -> {
            val intent = Intent(context, AudioActivity::class.java)
            intent.putExtra(AudioActivity.QUESTION, question.id)
            context.startActivity(intent)
            return
        }
        "boolean" -> {
            val intent = Intent(context, BooleanActivity::class.java)
            intent.putExtra(BooleanActivity.QUESTION, question.id)
            intent.putExtra(BooleanActivity.NEXT_QUESTION, getNextQuestion(number, interview.questions))
            intent.putExtra(BooleanActivity.PREVIOUS_QUESTION, getPreviousQuestion(number, interview.questions))
            context.startActivity(intent)
            return
        }
        "number" -> {
            val intent = Intent(context, NumberActivity::class.java)
            intent.putExtra(NumberActivity.QUESTION, question.id)
            context.startActivity(intent)
            return
        }
        "textarea" -> {
            val intent = Intent(context, TextAreaActivity::class.java)
            intent.putExtra(TextAreaActivity.QUESTION, question.id)
            context.startActivity(intent)
            return
        }
        "video" -> {
            val intent = Intent(context, VideoActivity::class.java)
            intent.putExtra(VideoActivity.QUESTION, question.id)
            context.startActivity(intent)
            return
        }
        "decimal" -> {
            val intent = Intent(context, DecimalActivity::class.java)
            intent.putExtra(DecimalActivity.QUESTION, question.id)
            context.startActivity(intent)
            return
        }
        "image" -> {
            val intent = Intent(context, PhotoActivity::class.java)
            intent.putExtra(PhotoActivity.QUESTION, question.id)
            context.startActivity(intent)
            return
        }
        "date" -> {
            val intent = Intent(context, DateActivity::class.java)
            intent.putExtra(DateActivity.QUESTION, question.id)
            context.startActivity(intent)
            return
        }
        "time" -> {
            val intent = Intent(context, TimeActivity::class.java)
            intent.putExtra(TimeActivity.QUESTION, question.id)
            context.startActivity(intent)
            return
        }

        "multiple_select" -> {
            val intent = Intent(context, MultipleSelectionActivity::class.java)
            intent.putExtra(MultipleSelectionActivity.QUESTION, question.id)
            context.startActivity(intent)
        }

        "text" -> {
            val intent = Intent(context, TextActivity::class.java)
            intent.putExtra(TextActivity.QUESTION, question.id)
            context.startActivity(intent)
        }
    }
}

fun getPreviousQuestion(number: Int, questions: List<Question>): Question {
    if (number <= 0) {
        return questions[0]
    }
    return questions[number]
}

fun getNextQuestion(currentQuestion: Int, questions: List<Question>): Question {
    if (currentQuestion <= 0) {
        return questions.get(0)
    }

    if (currentQuestion >= questions.size) {
        return questions[currentQuestion + 1]
    }
    return questions[currentQuestion]
}