package com.cresonnglobal.mdcp.date

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cresonnglobal.mdcp.R

class DateActivity : AppCompatActivity() {
    companion object {
        public final val QUESTION = "com.cresonnglobal.mdcp.date.DateActivity.QUESTION"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)
    }
}