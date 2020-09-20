package com.cresonnglobal.mdcp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.cresonnglobal.mdcp.data.question.Interview

class MainActivityViewModel(application: Application): AndroidViewModel(application) {
    private val repository: Repository = Repository.getRepository(application)

    fun getInterview(): Interview? {
        return repository.getInterview()
    }

    fun getRepository(): Repository {
        return repository
    }

    fun getInterviews(): Interview {
        return  repository.getInterviews()
    }
}