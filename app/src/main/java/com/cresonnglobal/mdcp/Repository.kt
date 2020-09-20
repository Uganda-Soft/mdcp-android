package com.cresonnglobal.mdcp

import android.content.Context
import android.util.Log
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

    fun insertAnswer(answer: Answer): List<Answer> {
        val thread = Executors.newSingleThreadExecutor()
        return thread.submit(Callable {
            database.answerDao().insertAnswer(answer)
            database.answerDao().getAnswersForQuestion(answer.questionId)
        }).get()
    }

    fun insertType(type: Type) : Type {
        val thread = Executors.newSingleThreadExecutor()
        return thread.submit(Callable {
            database.typeDao().insertType(type)
            database.typeDao().getTypeForQuestion(type.questionId)
        }).get()
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

    fun insertRequiredMessage(requiredMessage: RequiredMessage): List<RequiredMessage> {
        val thread = Executors.newSingleThreadExecutor()
        return thread.submit(Callable {
            database.requiredMessageDao().insertRequiredMessage(requiredMessage)
            database.requiredMessageDao().getRequiredMessageForQuestion(requiredMessage.questionId)
        }).get()
    }

    fun insertMedia(media: Media): List<Media> {
        val thread = Executors.newSingleThreadExecutor()
        return thread.submit(Callable {
            database.mediaDao().insertMedia(media)
            database.mediaDao().getMediaForQuestion(media.questionId)
        }).get()
    }

    fun insertRange(range: Range): Range {
        val thread = Executors.newSingleThreadExecutor()
        return thread.submit(Callable {
            database.rangeDao().insertRange(range)
            database.rangeDao().getRangeForType(range.typeId)
        }).get()
    }

    fun getInterviews(): List<Interview> {
        val thread = Executors.newSingleThreadExecutor()
        return thread.submit(Callable {
            val interviews = database.interviewDao().getInterviewList()
            for (interview in interviews) {
                val meta = database.metaDao().getMetaForInterview(interview.id)
                Log.d("Interview", interview.toString())
                meta.basic_info = database.basicInfoDao().getBasicInfoForMeta(meta.id)
                interview.meta = meta
                val questions = mutableListOf<Question>()

                for (question in database.questionDao().getQuestionForInterview(interview.id)) {
                    question.constraint_messages = database.constraintMessageDao().getConstraintMessageForQuestion(question.id)
                    question.constraints = database.constraintDao().getConstraintsForQuestion(question.id)
                    question.required_message = database.requiredMessageDao().getRequiredMessageForQuestion(question.id)
                    question.media = database.mediaDao().getMediaForQuestion(question.id)
                    val type = database.typeDao().getTypeForQuestion(question.id)
                    type.range = database.rangeDao().getRangeForType(type.id)
                    question.type = type
                    val answers = database.answerDao().getAnswersForQuestion(question.id)
                    question.answers = answers
                    questions.add(question)
                }
                interview.questions = questions.toList()
            }
            interviews
        }).get();
    }

    fun getQuestion(questionId: Int): Question {
        val thread = Executors.newSingleThreadExecutor()
        return thread.submit(Callable {
            val question = database.questionDao().getQuestion(questionId)
            question.constraint_messages = database.constraintMessageDao().getConstraintMessageForQuestion(question.id)
            question.constraints = database.constraintDao().getConstraintsForQuestion(question.id)
            question.required_message = database.requiredMessageDao().getRequiredMessageForQuestion(question.id)
            question.media = database.mediaDao().getMediaForQuestion(question.id)
            val type = database.typeDao().getTypeForQuestion(question.id)
            type.range = database.rangeDao().getRangeForType(type.id)
            question.type = type
            val answers = database.answerDao().getAnswersForQuestion(question.id)
            question.answers = answers
            question
        }).get()
    }

    fun updateAnswer(answer: Answer) {
        val thread = Executors.newSingleThreadExecutor()
        thread.execute(Runnable {
            database.answerDao().updateAnswer(answer)
        })
    }

//    fun queryQuestions(): List<Question> {
//        val thread = Executors.newSingleThreadExecutor()
//        return thread.submit(Callable {
//            database.questionDao().queryQuestion()
//        }).get()
//    }
}