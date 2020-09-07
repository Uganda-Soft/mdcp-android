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
import com.cresonnglobal.mdcp.common.startActivityForType
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
        startActivityForType(question, this)
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

            R.id.action_view_note -> startNoteActivity(this, viewModel.getInterview()?.meta?.note)
            R.id.action_view_constraints -> viewModel.getInterview()?.let {
                it.meta?.let {meta: Meta -> startConstraintActivity(this, meta.constraint_message)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}