package com.cresonnglobal.mdcp

import android.content.Context
import androidx.lifecycle.LiveData
import com.cresonnglobal.mdcp.data.CresonnglobalDatabase
import com.cresonnglobal.mdcp.data.question.*
import java.util.concurrent.Callable
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

    fun insertType(type: Type) {
        val thread = Executors.newSingleThreadExecutor()
        thread.submit(Runnable {
            database.typeDao().insertType(type)
        })
    }

//    fun insertQuestion(question: Question) {
//        val thread = Executors.newSingleThreadExecutor()
//        thread.submit(Runnable {
//            database.questionDao().insertQuestion(question)
//        })
//    }


    fun queryAnswers(): LiveData<List<Answer>> {
        val thread = Executors.newSingleThreadExecutor()
        return thread.submit(Callable {
            database.answerDao().queryAnswers()
        }).get()
    }

    fun queryType(): LiveData<List<Type>> {
        val thread = Executors.newSingleThreadExecutor()
        return thread.submit(Callable {
            database.typeDao().queryTypes()
        }).get()
    }

    fun insertInterview(interview: Interview): Interview {
        val thread = Executors.newSingleThreadExecutor()
        return thread.submit(Callable {
            database.interviewDao().insertInterview(interview)
            database.interviewDao().getLatestInterview()
        }).get()
    }

    fun insertMeta(meta: Meta): Meta {
        val thread = Executors.newSingleThreadExecutor()
        return thread.submit(Callable {
            database.metaDao().insertMeta(meta)
            database.metaDao().getLatestMeta()
        }).get()
    }

    fun insertBasicInfo(basicInfo: BasicInfo): List<BasicInfo> {
        val thread = Executors.newSingleThreadExecutor()
        return thread.submit(Callable {
            database.basicInfoDao().insertBasicInfo(basicInfo)
            database.basicInfoDao().getBasicInfoForMeta(basicInfo.metaId)
        }).get()
    }

    fun insertQuestion(question1: Question): Question {
        val thread = Executors.newSingleThreadExecutor()
        return thread.submit(Callable {
            database.questionDao().insertQuestion(question1)
            database.questionDao().getLatestQuestion()
        }).get()
    }

    fun insertConstraintMessage(constraintMessage: ConstraintMessage): List<ConstraintMessage> {
        val thread = Executors.newSingleThreadExecutor()
        return thread.submit(Callable {
            database.constraintMessageDao().insertConstraintMessage(constraintMessage)
            database.constraintMessageDao().getConstraintMessageForQuestion(constraintMessage.questionId)
        }).get()
    }

    fun insertConstraint(constraint: Constraint): List<Constraint> {
        val thread = Executors.newSingleThreadExecutor()
        return thread.submit(Callable {
            database.constraintDao().insertConstraint(constraint)
            database.constraintDao().getConstraintsForQuestion(constraint.questionId)
        }).get()
    }

//    fun queryQuestions(): List<Question> {
//        val thread = Executors.newSingleThreadExecutor()
//        return thread.submit(Callable {
//            database.questionDao().queryQuestion()
//        }).get()
//    }
}