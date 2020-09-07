package com.cresonnglobal.mdcp.booleans

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.cresonnglobal.mdcp.R
import com.cresonnglobal.mdcp.data.question.Question
import com.cresonnglobal.mdcp.helpers.NoteViewerActivity
import com.cresonnglobal.mdcp.helpers.contraints.ConstraintViewActivityActivity
import com.cresonnglobal.mdcp.helpers.startConstraintActivity
import com.cresonnglobal.mdcp.helpers.startNoteActivity
import kotlinx.android.synthetic.main.activity_boolean.*

class BooleanActivity : AppCompatActivity() {
    private lateinit var viewModel: BooleansActivityViewModel;
    private lateinit var previousButton: Button
    private lateinit var nextButton: Button
    companion object {
        public final const val QUESTION: String = "com.cresonnglobal.mdcp.audio.BooleanActivity.QUESTION"
        public final const val NEXT_QUESTION: String = "com.cresonnglobal.mdcp.audio.BooleanActivity.NEXT_QUESTION"
        public final const val PREVIOUS_QUESTION: String = "com.cresonnglobal.mdcp.audio.BooleanActivity.PREVIOUS_QUESTION"
    }
    private var question: Question? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boolean)

        viewModel = ViewModelProvider(this).get(BooleansActivityViewModel::class.java)
        previousButton = previous
        nextButton = next

        question = intent.getParcelableExtra<Question>(QUESTION)
        name.text = question?.name
        label.text = question?.label
        hint.text = question?.hint


        startNoteActivity(this, question)
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
            R.id.action_view_constraints -> startConstraintActivity(this, question?.constraint_message)
            R.id.action_view_help -> {
                // show help
            }

            R.id.action_view_note -> startNoteActivity(this, question)
        }
        return super.onOptionsItemSelected(item)
    }
}