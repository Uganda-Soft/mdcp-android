package com.cresonnglobal.mdcp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cresonnglobal.mdcp.data.question.*

@Database(entities = [
    Answer::class,
    BasicInfo::class,
    Constraint::class,
    Media::class,
    ConstraintMessage::class,
    Selection::class,
    Type::class,
    RequiredMessage::class
//    Question::class
], version = 1, exportSchema = false)
abstract class CresonnglobalDatabase: RoomDatabase() {
    abstract fun answerDao(): AnswerDao
    abstract fun basicInfoDao(): BasicInfoDao
    abstract fun constraintDao(): ConstraintDao
    abstract fun mediaDao(): MediaDao
    abstract fun constraintMessageDao(): ConstraintMessageDao
    abstract fun selectionDao(): SelectionDao
    abstract fun typeDao(): TypeDao
    abstract fun requiredMessageDao(): RequiredMessageDao
//    abstract fun questionDao(): QuestionDao

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