package com.cresonnglobal.mdcp.data_collection

import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cresonnglobal.mdcp.R
import java.io.InputStream

class DataCollectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_collection)

        val assetManager: AssetManager = assets;
        val inputStream: InputStream = assetManager.open("question/sample.json")
        Toast.makeText(this, inputStream.toString(), Toast.LENGTH_SHORT).show();
    }
}