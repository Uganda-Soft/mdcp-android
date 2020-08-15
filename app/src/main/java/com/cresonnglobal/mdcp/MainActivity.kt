package com.cresonnglobal.mdcp

import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.cresonnglobal.mdcp.data.question.Interview
import com.cresonnglobal.mdcp.widgets.audio.AudioFragment
import com.cresonnglobal.mdcp.widgets.booleans.BooleanFragment
import com.cresonnglobal.mdcp.widgets.date_time.DateTimeFragment
import com.cresonnglobal.mdcp.widgets.decimals.DecimalFragment
import com.cresonnglobal.mdcp.widgets.long_text.TextAreaFragment
import com.cresonnglobal.mdcp.widgets.number.NumberFragment
import com.cresonnglobal.mdcp.widgets.text.TextFragment
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    private lateinit var questionCollectionPagerAdapter: QuestionCollectionPagerAdapter;
    private lateinit var viewPager: ViewPager;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val assetManager: AssetManager = assets;
        val inputStream: InputStream = assetManager.open("question/sample.json")
        val bufferedReader: BufferedReader = BufferedReader(InputStreamReader(inputStream))
        val interview: Interview = Gson().fromJson(bufferedReader, Interview::class.java)
        questionCollectionPagerAdapter = QuestionCollectionPagerAdapter(supportFragmentManager, interview);

        viewPager = pager;
        viewPager.adapter = questionCollectionPagerAdapter;

        Log.d("MainActivity", interview.toString())
    }

    class QuestionCollectionPagerAdapter(fm: FragmentManager, private val interview: Interview): FragmentStatePagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            val question = interview.questions[position]

            if (question.type_name.type == "text") {
                return TextFragment(question);
            } else if (question.type_name.type == "date") {
                return DateTimeFragment(question)
            } else if (question.type_name.type == "decimal") {
                return DecimalFragment(question)
            } else if (question.type_name.type == "audio") {
                return AudioFragment(question)
            } else if (question.type_name.type == "textarea") {
                return TextAreaFragment(question)
            } else if (question.type_name.type == "number") {
                return NumberFragment(question)
            }  else {
                return BooleanFragment(question)
            }
        }

        override fun getCount(): Int {
            return interview.questions.size;
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return "OBJECT ${(position + 1)}";
        }

    }
}