package com.cresonnglobal.mdcp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cresonnglobal.mdcp.common.startActivityForType
import com.cresonnglobal.mdcp.data.question.Answer
import com.cresonnglobal.mdcp.data.question.Meta
import com.cresonnglobal.mdcp.data.question.Question
import com.cresonnglobal.mdcp.helpers.startConstraintActivity
import com.cresonnglobal.mdcp.helpers.startNoteActivity
import com.cresonnglobal.mdcp.settings.SettingsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), QuestionAdapter.OnQuestionClickListener{
    private var totalQuestion: Int = 0
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getRepository().insertAnswer(Answer(
            id = null,
            message = "Hello World",
            date = "23-09-2020",
            time = "08:30am",
            duration = "05min",
            logitude = 78984847374,
            latitude = 34434343433
        ))

        viewModel.getRepository().queryAnswers().observe(this, Observer {
            Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
        })

    }

    override fun onQuestionClick(question: Question, number: Int) {
//        startActivityForType(question, this, viewModel.getInterview(), number)
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
        }
        return super.onOptionsItemSelected(item)
    }
}