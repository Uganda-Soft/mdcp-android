package com.cresonnglobal.mdcp.helpers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cresonnglobal.mdcp.R
import kotlinx.android.synthetic.main.activity_note_viewer.*

class NoteViewerActivity : AppCompatActivity() {
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
    }
}