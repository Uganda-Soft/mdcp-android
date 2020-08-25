package com.cresonnglobal.mdcp.textarea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cresonnglobal.mdcp.R

class TextAreaActivity : AppCompatActivity() {
    companion object {
        public final val QUESTION = "com.cresonnglobal.mdcp.textarea.TextAreaActivity.QUESTION"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_area)
    }
}