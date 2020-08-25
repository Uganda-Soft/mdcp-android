package com.cresonnglobal.mdcp

import android.content.Intent
import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.cresonnglobal.mdcp.audio.AudioActivity
import com.cresonnglobal.mdcp.booleans.BooleanActivity
import com.cresonnglobal.mdcp.data.question.Interview
import com.cresonnglobal.mdcp.data.question.Question
import com.cresonnglobal.mdcp.date.DateActivity
import com.cresonnglobal.mdcp.decimal.DecimalActivity
import com.cresonnglobal.mdcp.number.NumberActivity
import com.cresonnglobal.mdcp.photo.PhotoActivity
import com.cresonnglobal.mdcp.textarea.TextAreaActivity
import com.cresonnglobal.mdcp.time.TimeActivity
import com.cresonnglobal.mdcp.video.VideoActivity
import com.cresonnglobal.mdcp.widgets.audio.AudioFragment
import com.cresonnglobal.mdcp.widgets.booleans.BooleanFragment
import com.cresonnglobal.mdcp.widgets.date_time.DateTimeFragment
import com.cresonnglobal.mdcp.widgets.decimals.DecimalFragment
import com.cresonnglobal.mdcp.widgets.image.ImageFragment
import com.cresonnglobal.mdcp.widgets.long_text.TextAreaFragment
import com.cresonnglobal.mdcp.widgets.number.NumberFragment
import com.cresonnglobal.mdcp.widgets.text.TextFragment
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

class MainActivity : AppCompatActivity(), QuestionAdapter.OnQuestionClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val assetManager: AssetManager = assets;
        val inputStream: InputStream = assetManager.open("question/questions.json")
        val bufferedReader: BufferedReader = BufferedReader(InputStreamReader(inputStream))
        val interview: Interview = Gson().fromJson(bufferedReader, Interview::class.java)

        val recyclerView: RecyclerView = questions_list_recyclerview
        val questionAdapter: QuestionAdapter = QuestionAdapter(interview.questions, this)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = questionAdapter
    }

    override fun onQuestionClick(question: Question) {
        if (question.type_name?.type == "audio") {
            val intent: Intent = Intent(this, AudioActivity::class.java)
            intent.putExtra(AudioActivity.QUESTION, question)
            startActivity(intent)
        }

        if (question.type_name?.type == "boolean") {
            val intent = Intent(this, BooleanActivity::class.java)
            intent.putExtra(BooleanActivity.QUESTION, question)
            startActivity(intent)
        }

        if (question.type_name?.type == "number") {
            val intent = Intent(this, NumberActivity::class.java)
            intent.putExtra(NumberActivity.QUESTION, question)
            startActivity(intent)
        }

        if (question.type_name?.type == "textarea") {
            val intent = Intent(this, TextAreaActivity::class.java)
            intent.putExtra(TextAreaActivity.QUESTION, question)
            startActivity(intent)
        }

        if (question.type_name?.type == "video") {
            val intent = Intent(this, VideoActivity::class.java)
            intent.putExtra(VideoActivity.QUESTION, intent)
            startActivity(intent)
        }

        if (question.type_name?.type == "decimal") {
            val intent = Intent(this, DecimalActivity::class.java)
            intent.putExtra(DecimalActivity.QUESTION, question)
            startActivity(intent)
        }

        if (question.type_name?.type == "image") {
            val intent = Intent(this, PhotoActivity::class.java)
            intent.putExtra(PhotoActivity.QUESTION, question)
            startActivity(intent)
        }

        if (question.type_name?.type == "date") {
            val intent = Intent(this, DateActivity::class.java)
            intent.putExtra(DateActivity.QUESTION, question)
            startActivity(intent)
        }

        if (question.type_name?.type == "time") {
            val intent = Intent(this, TimeActivity::class.java)
            intent.putExtra(TimeActivity.QUESTION, question)
            startActivity(intent)
        }
    }
}