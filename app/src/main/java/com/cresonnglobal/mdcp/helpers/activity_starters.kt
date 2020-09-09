package com.cresonnglobal.mdcp.helpers

import android.content.Context
import android.content.Intent
import androidx.preference.PreferenceManager
import com.cresonnglobal.mdcp.data.question.Question
import com.cresonnglobal.mdcp.helpers.contraints.ConstraintViewActivityActivity

fun startNoteActivity(context: Context, Question: Question?) {
    startNoteActivity(context, Question?.note)
}

fun startNoteActivity(context: Context, note: String?) {
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    val showNote: Boolean = sharedPreferences.getBoolean("show_note_preference", true)
    if (showNote) {
        val intent = Intent(context, NoteViewerActivity::class.java)
        intent.putExtra(NoteViewerActivity.NOTE_TEXT, note)
        context.startActivity(intent)
    }
}

fun startConstraintActivity(context: Context, constraint: String? ) {
    val intent = Intent(context, ConstraintViewActivityActivity::class.java)
    intent.putExtra(ConstraintViewActivityActivity.CONSTRAINTS, constraint)
    context.startActivity(intent)
}

fun  startConstraintActivity(context: Context, constraintMessages:Array<String>?) {
    var message:String = ""
    if (constraintMessages != null) {
        for (messageText: String in constraintMessages) {
            message = message + messageText + "\n"
        }

    } else {
        message = "No Constraint Message Found"
    }
    startConstraintActivity(context, message)
}