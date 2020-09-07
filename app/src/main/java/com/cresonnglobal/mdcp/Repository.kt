package com.cresonnglobal.mdcp

import android.content.Context
import com.cresonnglobal.mdcp.data.question.Interview

class Repository private constructor(context: Context) {
    fun getInterview(): Interview {
        TODO("Not yet implemented")
    }

    init {

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
}