package com.cresonnglobal.mdcp.data.question

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Index
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ConstraintDao {
    @Insert
    fun insertConstraint(constraint: Constraint)

    @Query("SELECT * FROM constraints")
    fun queryConstraints(): LiveData<List<Constraint>>
    @Query("SELECT * FROM constraints WHERE questionId =:questionId")
    fun getConstraintsForQuestion(questionId: Int): List<Constraint>
}