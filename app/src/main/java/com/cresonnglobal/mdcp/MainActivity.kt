package com.cresonnglobal.mdcp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cresonnglobal.mdcp.common.startActivityForType
import com.cresonnglobal.mdcp.data.question.Interview
import com.cresonnglobal.mdcp.data.question.Question
import com.cresonnglobal.mdcp.dev.Seeder
import com.cresonnglobal.mdcp.interview.InterviewListActivity
import com.cresonnglobal.mdcp.settings.SettingsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), QuestionAdapter.OnQuestionClickListener{
    private var totalQuestion: Int = 0
    private lateinit var viewModel: MainActivityViewModel
    private final val SELECT_INTERVIEW_REQUEST_CODE = 89
    private lateinit var interview: Interview

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
//        Seeder(viewModel.getRepository()).seedInterview()
        // get all interview and pick the first one
        val interviews = viewModel.getInterviews()
        interview = interviews
        Log.d("MainActivity", interview.toString())

        val recyclerView: RecyclerView = questions_list_recyclerview

        val questionAdapter = QuestionAdapter(interview.questions, this);
        recyclerView.adapter = questionAdapter
        recyclerView.layoutManager = GridLayoutManager(this, 3)

    }

    override fun onQuestionClick(question: Question, number: Int) {
        startActivityForType(question, this, interview, number)
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

//            R.id.action_view_note -> startNoteActivity(this, viewModel.getInterview()?.meta?.note)
            R.id.action_select_interview -> {
                val intent = Intent(this, InterviewListActivity::class.java)
                startActivityForResult(intent, SELECT_INTERVIEW_REQUEST_CODE)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}