package com.cresonnglobal.mdcp.select

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.cresonnglobal.mdcp.R
import com.cresonnglobal.mdcp.data.question.Question
import com.cresonnglobal.mdcp.helpers.NoteViewerActivity
import com.cresonnglobal.mdcp.helpers.contraints.ConstraintViewActivityActivity
import com.cresonnglobal.mdcp.helpers.startConstraintActivity
import com.cresonnglobal.mdcp.helpers.startNoteActivity
import kotlinx.android.synthetic.main.activity_multiple_selection.*

class MultipleSelectionActivity : AppCompatActivity() {
    companion object {
        public final const val QUESTION = "com.cresonnglobal.mdcp.photo.MultipleSelectionActivity.QUESTION"
    }
    val selectedItems: MutableSet<String> = mutableSetOf()
    private var question: Question? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiple_selection)

        question = intent.getParcelableExtra<Question>(QUESTION)
        name.text = question?.name
        label.text = question?.label
        hint.text = question?.hint

        val selections: List<String>? = question?.type_name?.selections
        val listView: ListView = answer
        val adapter = selections?.let {
            ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_multiple_choice,
                it
            )
        }
        listView.choiceMode = ListView.CHOICE_MODE_MULTIPLE
        listView.adapter = adapter
        listView.setOnItemClickListener{ _, _, position, _ ->
            if (selectedItems.contains(selections?.get(position))) {
                if (selections != null) {
                    selectedItems.remove(selections[position])
                }
            } else {
                selections?.get(position)?.let { selectedItems.add(it) }
            }
        }

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