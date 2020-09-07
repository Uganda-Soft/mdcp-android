package com.cresonnglobal.mdcp.common

import android.content.Intent
import com.cresonnglobal.mdcp.audio.AudioActivity
import com.cresonnglobal.mdcp.booleans.BooleanActivity
import com.cresonnglobal.mdcp.date.DateActivity
import com.cresonnglobal.mdcp.decimal.DecimalActivity
import com.cresonnglobal.mdcp.number.NumberActivity
import com.cresonnglobal.mdcp.photo.PhotoActivity
import com.cresonnglobal.mdcp.select.MultipleSelectionActivity
import com.cresonnglobal.mdcp.text.TextActivity
import com.cresonnglobal.mdcp.textarea.TextAreaActivity
import com.cresonnglobal.mdcp.time.TimeActivity
import com.cresonnglobal.mdcp.video.VideoActivity

fun startActivityForType() {
    when (question.type_name?.type) {
        "audio" -> {
            val intent = Intent(this, AudioActivity::class.java)
            intent.putExtra(AudioActivity.QUESTION, question)
            startActivity(intent)
            return
        }
        "boolean" -> {
            val intent = Intent(this, BooleanActivity::class.java)
            intent.putExtra(BooleanActivity.QUESTION, question)
            intent.putExtra(BooleanActivity.QUESTION_ID, number)
            intent.putExtra(BooleanActivity.NEXT_QUESTION_ID, getNextQuestionID(number + 1))
            intent.putExtra(BooleanActivity.PREVIOUS_QUESTION_ID, getNextQuestionID(number - 1))
            startActivity(intent)
            return
        }
        "number" -> {
            val intent = Intent(this, NumberActivity::class.java)
            intent.putExtra(NumberActivity.QUESTION, question)
            startActivity(intent)
            return
        }
        "textarea" -> {
            val intent = Intent(this, TextAreaActivity::class.java)
            intent.putExtra(TextAreaActivity.QUESTION, question)
            startActivity(intent)
            return
        }
        "video" -> {
            val intent = Intent(this, VideoActivity::class.java)
            intent.putExtra(VideoActivity.QUESTION, question)
            startActivity(intent)
            return
        }
        "decimal" -> {
            val intent = Intent(this, DecimalActivity::class.java)
            intent.putExtra(DecimalActivity.QUESTION, question)
            startActivity(intent)
            return
        }
        "image" -> {
            val intent = Intent(this, PhotoActivity::class.java)
            intent.putExtra(PhotoActivity.QUESTION, question)
            startActivity(intent)
            return
        }
        "date" -> {
            val intent = Intent(this, DateActivity::class.java)
            intent.putExtra(DateActivity.QUESTION, question)
            startActivity(intent)
            return
        }
        "time" -> {
            val intent = Intent(this, TimeActivity::class.java)
            intent.putExtra(TimeActivity.QUESTION, question)
            startActivity(intent)
            return
        }

        "multiple_select" -> {
            val intent = Intent(this, MultipleSelectionActivity::class.java)
            intent.putExtra(MultipleSelectionActivity.QUESTION, question)
            startActivity(intent)
        }

        "text" -> {
            val intent = Intent(this, TextActivity::class.java)
            intent.putExtra(TextActivity.QUESTION, question)
            startActivity(intent)
        }
    }
}