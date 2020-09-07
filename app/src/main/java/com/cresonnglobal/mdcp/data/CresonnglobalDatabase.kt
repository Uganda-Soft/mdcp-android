package com.cresonnglobal.mdcp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(), version = 1, exportSchema = false)
abstract class CresonnglobalDatabase: RoomDatabase() {






    companion object {
        @Volatile
        private var INSTANCE: CresonnglobalDatabase? = null

        fun getDatabase(context: Context): CresonnglobalDatabase {
            val tempInstance = INSTANCE
            if ( tempInstance != null ) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CresonnglobalDatabase::class.java,
                    "cresonnglobal_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}