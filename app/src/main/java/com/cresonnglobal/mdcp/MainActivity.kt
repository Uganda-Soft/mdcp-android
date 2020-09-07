package com.cresonnglobal.mdcp

import android.content.Intent
import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cresonnglobal.mdcp.audio.AudioActivity
import com.cresonnglobal.mdcp.booleans.BooleanActivity
import com.cresonnglobal.mdcp.data.question.Interview
import com.cresonnglobal.mdcp.data.question.Meta
import com.cresonnglobal.mdcp.data.question.Question
import com.cresonnglobal.mdcp.date.DateActivity
import com.cresonnglobal.mdcp.decimal.DecimalActivity
import com.cresonnglobal.mdcp.helpers.startConstraintActivity
import com.cresonnglobal.mdcp.helpers.startNoteActivity
import com.cresonnglobal.mdcp.number.NumberActivity
import com.cresonnglobal.mdcp.photo.PhotoActivity
import com.cresonnglobal.mdcp.select.MultipleSelectionActivity
import com.cresonnglobal.mdcp.settings.SettingsActivity
import com.cresonnglobal.mdcp.text.TextActivity
import com.cresonnglobal.mdcp.textarea.TextAreaActivity
import com.cresonnglobal.mdcp.time.TimeActivity
import com.cresonnglobal.mdcp.video.VideoActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity(), QuestionAdapter.OnQuestionClickListener{
    private var totalQuestion: Int = 0
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)


        viewModel.getInterview()?.let {
            startNoteActivity(this, it.meta?.note)
            val recyclerView: RecyclerView = questions_list_recyclerview
            val questionAdapter = QuestionAdapter(it.questions, this)
            totalQuestion = it.questions.size
            recyclerView.layoutManager = GridLayoutManager(this, 2)
            recyclerView.adapter = questionAdapter
        }
    }

    override fun onQuestionClick(question: Question, number: Int) {
        when (question.type_name?.type) {
            "audio" -> {
                val intent = Intent(this, AudioActivity::class.java)
                intent.putExtra(AudioActivity.QUESTION, question)
                startActivity(intent)
                return
            }
            "boolean" -> {
                val intent = Intent(this, BooleanActivity::class.java)
                intent.putExtra(BooleanActivity.QUESTION, question)
                intent.putExtra(BooleanActivity.QUESTION_ID, number)
                intent.putExtra(BooleanActivity.NEXT_QUESTION_ID, getNextQuestionID(number + 1))
                intent.putExtra(BooleanActivity.PREVIOUS_QUESTION_ID, getNextQuestionID(number - 1))
                startActivity(intent)
                return
            }
            "number" -> {
                val intent = Intent(this, NumberActivity::class.java)
                intent.putExtra(NumberActivity.QUESTION, question)
                startActivity(intent)
                return
            }
            "textarea" -> {
                val intent = Intent(this, TextAreaActivity::class.java)
                intent.putExtra(TextAreaActivity.QUESTION, question)
                startActivity(intent)
                return
            }
            "video" -> {
                val intent = Intent(this, VideoActivity::class.java)
                intent.putExtra(VideoActivity.QUESTION, question)
                startActivity(intent)
                return
            }
            "decimal" -> {
                val intent = Intent(this, DecimalActivity::class.java)
                intent.putExtra(DecimalActivity.QUESTION, question)
                startActivity(intent)
                return
            }
            "image" -> {
                val intent = Intent(this, PhotoActivity::class.java)
                intent.putExtra(PhotoActivity.QUESTION, question)
                startActivity(intent)
                return
            }
            "date" -> {
                val intent = Intent(this, DateActivity::class.java)
                intent.putExtra(DateActivity.QUESTION, question)
                startActivity(intent)
                return
            }
            "time" -> {
                val intent = Intent(this, TimeActivity::class.java)
                intent.putExtra(TimeActivity.QUESTION, question)
                startActivity(intent)
                return
            }

            "multiple_select" -> {
                val intent = Intent(this, MultipleSelectionActivity::class.java)
                intent.putExtra(MultipleSelectionActivity.QUESTION, question)
                startActivity(intent)
            }

            "text" -> {
                val intent = Intent(this, TextActivity::class.java)
                intent.putExtra(TextActivity.QUESTION, question)
                startActivity(intent)
            }
        }
    }

    private fun getNextQuestionID(number: Int): Int {
        if ( number < 0) {
            return 0
        } else if (number > totalQuestion) {
            return totalQuestion - 1;
        }
        return number
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }

            R.id.action_view_note -> startNoteActivity(this, interview?.meta?.note)
            R.id.action_view_constraints -> interview?.let {
                it.meta?.let {meta: Meta -> startConstraintActivity(this, meta.constraint_message)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}