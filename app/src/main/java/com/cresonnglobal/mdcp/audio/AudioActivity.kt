package com.cresonnglobal.mdcp.audio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.cresonnglobal.mdcp.R
import com.cresonnglobal.mdcp.data.question.Question
import com.cresonnglobal.mdcp.helpers.startNoteActivity
import kotlinx.android.synthetic.main.activity_audio.*

class AudioActivity : AppCompatActivity() {
    companion object {
        public final const val QUESTION_ID: String = "com.cresonnglobal.mdcp.audio.AudioActivity.QUESTION_ID"
    }
    private lateinit var question: Question
    private lateinit var audioActivityViewModel: AudioActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio)

        audioActivityViewModel = ViewModelProvider(this).get(AudioActivityViewModel::class.java)
        question = audioActivityViewModel.getQuestion(intent.getIntExtra(QUESTION_ID, 0))


        question_label.text = question.label
        question_name.text = question.name
        question_hint.text = question.hint
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
//            R.id.action_view_constraints -> startConstraintActivity(this, question?.constraint_message)
            R.id.action_view_help -> {
                // show help
            }

            R.id.action_view_note -> startNoteActivity(this, question)
        }
        return super.onOptionsItemSelected(item)
    }
}