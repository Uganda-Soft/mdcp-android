package com.cresonnglobal.mdcp.booleans

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cresonnglobal.mdcp.R

class BooleanActivity : AppCompatActivity() {
    companion object {
        public final val QUESTION: String = "com.cresonnglobal.mdcp.audio.BooleanActivity.QUESTION"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boolean)
    }
}