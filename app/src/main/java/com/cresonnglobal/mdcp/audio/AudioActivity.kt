package com.cresonnglobal.mdcp.audio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.cresonnglobal.mdcp.R
import com.cresonnglobal.mdcp.data.question.Question
import kotlinx.android.synthetic.main.activity_audio.*

class AudioActivity : AppCompatActivity() {
    companion object {
        public final const val QUESTION: String = "com.cresonnglobal.mdcp.audio.AudioActivity.QUESTION"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio)

        val question: Question? = intent.getParcelableExtra<Question>(QUESTION)
        name.text = question?.name
        label.text = question?.label
        hint.text = question?.hint
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
           R.id.action_view_constraints -> {
               // view actions constraints
           }

           R.id.action_view_help -> {
               // show help
           }
       }
        return super.onOptionsItemSelected(item)
    }
}