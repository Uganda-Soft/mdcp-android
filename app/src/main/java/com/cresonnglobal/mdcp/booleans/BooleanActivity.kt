package com.cresonnglobal.mdcp.booleans

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cresonnglobal.mdcp.R
import com.cresonnglobal.mdcp.data.question.Question
import kotlinx.android.synthetic.main.activity_boolean.*

class BooleanActivity : AppCompatActivity() {
    companion object {
        public final val QUESTION: String = "com.cresonnglobal.mdcp.audio.BooleanActivity.QUESTION"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boolean)

        val question: Question? = intent.getParcelableExtra<Question>(QUESTION)

// There is some name mismatch here this is not mistake
        name.text = question?.name
        label.text = question?.label
        hint.text = question?.hint
    }
}