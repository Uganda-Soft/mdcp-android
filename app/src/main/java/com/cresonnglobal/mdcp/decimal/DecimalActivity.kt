package com.cresonnglobal.mdcp.decimal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cresonnglobal.mdcp.R
import com.cresonnglobal.mdcp.data.question.Question
import kotlinx.android.synthetic.main.activity_decimal.*

class DecimalActivity : AppCompatActivity() {
    companion object {
        public final const val QUESTION = "com.cresonnglobal.mdcp.decimal.DecimalActivity.QUESTION"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_decimal)

        val question: Question? = intent.getParcelableExtra<Question>(QUESTION)
        name.text = question?.name
        label.text = question?.label
        hint.text = question?.hint
    }
}