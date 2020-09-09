package com.cresonnglobal.mdcp.date

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.cresonnglobal.mdcp.R
import com.cresonnglobal.mdcp.data.question.MDCPQuestion
import com.cresonnglobal.mdcp.helpers.startNoteActivity

class DateActivity : AppCompatActivity() {
    companion object {
        public final const val QUESTION = "com.cresonnglobal.mdcp.date.DateActivity.QUESTION"
    }
    private var MDCPQuestion: MDCPQuestion? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)

//        question = intent.getParcelableExtra<Question>(QUESTION)
//        name.text = question?.name
//        label.text = question?.label
//        hint.text = question?.hint

        startNoteActivity(this, MDCPQuestion)
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

            R.id.action_view_note -> {
                startNoteActivity(this, MDCPQuestion)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}