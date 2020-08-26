package com.cresonnglobal.mdcp.helpers

import android.app.Activity
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.preference.PreferenceManager
import com.cresonnglobal.mdcp.R
import kotlinx.android.synthetic.main.activity_note_viewer.*

class NoteViewerActivity : Activity() {
    companion object {
        public final const val NOTE_TEXT = "com.cresonnglobal.mdcp.helpers.NoteViewerActivity.NOTE_TEXT"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_viewer)

        val inComingIntent = intent
        val noteText:String? = inComingIntent.getStringExtra(NOTE_TEXT)
        noteText?.let {
            note.text = it
        }

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val autoRemove: Boolean = sharedPreferences.getBoolean("dont_auto_close_note", true)
        if (autoRemove) {
            Handler().postDelayed(Runnable {
                finish()
            }, 5000)
        }
    }
}