package com.cresonnglobal.mdcp.audio

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.cresonnglobal.mdcp.Repository
import com.cresonnglobal.mdcp.data.question.Question

class AudioActivityViewModel (application: Application): AndroidViewModel(application) {
    val repository = Repository.getRepository(application)
    fun getQuestion(questionId: Int): Question {
        return repository.getQuestion(questionId)
    }

}