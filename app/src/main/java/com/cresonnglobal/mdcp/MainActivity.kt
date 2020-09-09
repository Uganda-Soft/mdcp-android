package com.cresonnglobal.mdcp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cresonnglobal.mdcp.data.question.Question
import com.cresonnglobal.mdcp.settings.SettingsActivity

class MainActivity : AppCompatActivity(), QuestionAdapter.OnQuestionClickListener{
    private var totalQuestion: Int = 0
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
//        viewModel.getRepository().insertQuestion(
//            Question(
//            78,
//            "Sq23",
//            "Label",
//            "This was the hint",
//            "None",
//            "Text box",
//            "This required",
//            "True",
//            "NO",
//            "Yes",
//            "This ",
//            "Better",
//            "No Choice",
//            "The Man",
//            "The Writer",
//            "Thre",
//            "Not"
//        )
//        )


        viewModel.getRepository().queryAnswers().observe(this, Observer {
            Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
        })
//        val data = viewModel.getRepository().queryQuestions()

    }

    override fun onQuestionClick(Question: Question, number: Int) {
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