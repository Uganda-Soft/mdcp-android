package com.cresonnglobal.mdcp.video

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cresonnglobal.mdcp.R

class VideoActivity : AppCompatActivity() {
    companion object {
        public final val QUESTION = "com.cresonnglobal.mdcp.video.VideoActivity.QUESTION"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
    }
}