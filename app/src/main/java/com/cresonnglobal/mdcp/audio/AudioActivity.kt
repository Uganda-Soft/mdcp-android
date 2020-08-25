package com.cresonnglobal.mdcp.audio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cresonnglobal.mdcp.R

class AudioActivity : AppCompatActivity() {
    companion object {
        public final val QUESTION: String = "com.cresonnglobal.mdcp.audio.AudioActivity.QUESTION"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio)
    }
}