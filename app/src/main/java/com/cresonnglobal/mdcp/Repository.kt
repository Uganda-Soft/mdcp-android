package com.cresonnglobal.mdcp

import android.content.Context
import android.content.res.AssetManager
import com.cresonnglobal.mdcp.data.CresonnglobalDatabase
import com.cresonnglobal.mdcp.data.question.Answer
import com.cresonnglobal.mdcp.data.question.Interview
import com.cresonnglobal.mdcp.data.question.Question
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class Repository private constructor(context: Context) {
    private var interview: Interview? = null
    private var database: CresonnglobalDatabase = CresonnglobalDatabase.getDatabase(context)
    fun getInterview(): Interview? {
        return interview
    }

    init {
//        val assetManager: AssetManager = context.assets
//        val inputStream: InputStream = assetManager.open("question/questions.json")
//        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
//        interview = Gson().fromJson(bufferedReader, Interview::class.java)
    }

    companion object {
        @Volatile
        private var INSTANCE: Repository? = null

        fun getRepository(context: Context): Repository {
            val tempInstance = INSTANCE
            if (tempInstance != null ) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Repository(context)
                INSTANCE = instance;
                return instance
            }
        }
    }

    fun insertAnswer(answer: Answer) {
        val thread = Executors.newSingleThreadExecutor()
        thread.submit(Runnable {
            database.answerDao().insertAnswer(answer)
        })
    }
}