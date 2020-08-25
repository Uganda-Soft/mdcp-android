package com.cresonnglobal.mdcp.number

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cresonnglobal.mdcp.R

class NumberActivity : AppCompatActivity() {
    companion object {
        public final val QUESTION: String = "com.cresonnglobal.mdcp.number.NumberActivity.QUESTION"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number)
    }
}