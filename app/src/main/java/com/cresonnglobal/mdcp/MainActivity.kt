package com.cresonnglobal.mdcp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.cresonnglobal.mdcp.data_collection.DataCollectionActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = sample;
        button.setOnClickListener {
//            val intent = Intent(MainActivity.class, DataCollectionActivity)
//            startActivity(intent)
        }
    }
}