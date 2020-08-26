package com.cresonnglobal.mdcp.decimal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.cresonnglobal.mdcp.R
import com.cresonnglobal.mdcp.data.question.Question
import com.cresonnglobal.mdcp.helpers.NoteViewerActivity
import com.cresonnglobal.mdcp.helpers.contraints.ConstraintViewActivityActivity
import kotlinx.android.synthetic.main.activity_decimal.*

class DecimalActivity : AppCompatActivity() {
    companion object {
        public final const val QUESTION = "com.cresonnglobal.mdcp.decimal.DecimalActivity.QUESTION"
    }
    private var question: Question? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_decimal)

        question = intent.getParcelableExtra<Question>(QUESTION)
        name.text = question?.name
        label.text = question?.label
        hint.text = question?.hint
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
            R.id.action_view_constraints -> {
                val intent = Intent(this,  ConstraintViewActivityActivity::class.java)
                intent.putExtra(ConstraintViewActivityActivity.CONSTRAINTS, question?.constraint_message)
                startActivity(intent)
            }

            R.id.action_view_help -> {
                // show help
            }

            R.id.action_view_note -> startNoteActivity()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun startNoteActivity() {
        val intent = Intent(this, NoteViewerActivity::class.java)
        intent.putExtra(NoteViewerActivity.NOTE_TEXT, question?.note)
        startActivity(intent)
    }
}