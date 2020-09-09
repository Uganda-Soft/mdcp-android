package com.cresonnglobal.mdcp.textarea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.cresonnglobal.mdcp.R
import com.cresonnglobal.mdcp.data.question.Question
import com.cresonnglobal.mdcp.helpers.startNoteActivity

class TextAreaActivity : AppCompatActivity() {
    companion object {
        public final const val QUESTION = "com.cresonnglobal.mdcp.textarea.TextAreaActivity.QUESTION"
    }
    private var Question: Question? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_area)

//        question = intent.getParcelableExtra<Question>(QUESTION)
//        name.text = question?.name
//        label.text = question?.label
//        hint.text = question?.hint
//        startNoteActivity(this, question)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.screen_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_clear -> {
                // clear answers
                return true
            }
//            R.id.action_view_constraints -> startConstraintActivity(this, question?.constraint_message)

            R.id.action_view_help -> {
                // show help
            }

            R.id.action_view_note -> startNoteActivity(this, Question)
        }
        return super.onOptionsItemSelected(item)
    }
}