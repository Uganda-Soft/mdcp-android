package com.cresonnglobal.mdcp.helpers

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.cresonnglobal.mdcp.data.question.Question

fun startNoteActivity(context: Context, question: Question?) {
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    val showNote: Boolean = sharedPreferences.getBoolean("show_note_preference", true)
    if (showNote) {
        val intent = Intent(context, NoteViewerActivity::class.java)
        intent.putExtra(NoteViewerActivity.NOTE_TEXT, question?.note)
        context.startActivity(intent)
    }
}