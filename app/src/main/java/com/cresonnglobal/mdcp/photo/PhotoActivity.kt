package com.cresonnglobal.mdcp.photo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cresonnglobal.mdcp.R

class PhotoActivity : AppCompatActivity() {
    companion object {
        public final val QUESTION = "com.cresonnglobal.mdcp.photo.PhotoActivity.QUESTION"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)
    }
}