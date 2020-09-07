package com.cresonnglobal.mdcp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.cresonnglobal.mdcp.data.question.Interview

class MainActivityViewModel(application: Application): AndroidViewModel(application) {
    private val interview: Interview
    private val repository: Repository

    init {
        repository = Repository.getRepository(application)
        interview = repository.getInterview()
    }
}