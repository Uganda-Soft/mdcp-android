package com.cresonnglobal.mdcp.booleans

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.cresonnglobal.mdcp.Repository
import com.cresonnglobal.mdcp.data.question.Interview

class BooleansActivityViewModel (application: Application): AndroidViewModel(application) {
    private val repository: Repository = Repository.getRepository(application)

    fun getInterview(): Interview? {
        return repository.getInterview()
    }

    fun getRepository(): Repository {
        return repository
    }

}