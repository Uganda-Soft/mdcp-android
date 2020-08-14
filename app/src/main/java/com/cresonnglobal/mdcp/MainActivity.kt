package com.cresonnglobal.mdcp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.cresonnglobal.mdcp.data_collection.DataCollectionActivity
import com.cresonnglobal.mdcp.widgets.long_text.TextAreaFragment
import com.cresonnglobal.mdcp.widgets.text.TextFragment
import com.cresonnglobal.mdcp.widgets.video.VideoFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var questionCollectionPagerAdapter: QuestionCollectionPagerAdapter;
    private lateinit var viewPager: ViewPager;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        questionCollectionPagerAdapter = QuestionCollectionPagerAdapter(supportFragmentManager);

        viewPager = pager;
        viewPager.adapter = questionCollectionPagerAdapter;

    }

    class QuestionCollectionPagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            val fragment = TextAreaFragment();
            fragment.arguments = Bundle().apply {
                putInt("object", position + 1)
            }
            return fragment;
        }

        override fun getCount(): Int {
            return 100;
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return "OBJECT ${(position + 1)}";
        }

    }
}