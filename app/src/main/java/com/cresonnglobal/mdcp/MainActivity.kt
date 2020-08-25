package com.cresonnglobal.mdcp

import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.cresonnglobal.mdcp.data.question.Interview
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

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager;

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
}