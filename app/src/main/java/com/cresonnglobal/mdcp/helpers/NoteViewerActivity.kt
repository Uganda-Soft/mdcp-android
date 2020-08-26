package com.cresonnglobal.mdcp.helpers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cresonnglobal.mdcp.R

class NoteViewerActivity : AppCompatActivity() {
    companion object {
        public final const val NOTE_TEXT = "com.cresonnglobal.mdcp.helpers.NoteViewerActivity.NOTE_TEXT"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_viewer)
    }
}