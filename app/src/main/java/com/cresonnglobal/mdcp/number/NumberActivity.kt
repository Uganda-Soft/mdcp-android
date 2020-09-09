package com.cresonnglobal.mdcp.number

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.cresonnglobal.mdcp.R
import com.cresonnglobal.mdcp.data.question.MDCPQuestion
import com.cresonnglobal.mdcp.helpers.startNoteActivity

class NumberActivity : AppCompatActivity() {
    companion object {
        public final const val QUESTION: String = "com.cresonnglobal.mdcp.number.NumberActivity.QUESTION"
    }
    private var MDCPQuestion:MDCPQuestion? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number)

//        val question: Question? = intent.getParcelableExtra<Question>(QUESTION)
//        name.text = question?.name
//        label.text = question?.label
//        hint.text = question?.hint
//
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

            R.id.action_view_note -> startNoteActivity(this, MDCPQuestion)
        }
        return super.onOptionsItemSelected(item)
    }
}