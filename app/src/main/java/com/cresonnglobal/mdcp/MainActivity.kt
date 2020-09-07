package com.cresonnglobal.mdcp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cresonnglobal.mdcp.common.startActivityForType
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