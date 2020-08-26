package com.cresonnglobal.mdcp.helpers.contraints

import android.app.Activity
import android.os.Bundle
import com.cresonnglobal.mdcp.R

class ConstraintViewActivityActivity : Activity() {
    companion object {
        public final const val CONSTRAINTS = "com.cresonnglobal.mdcp.helpers.contraints.ConstraintViewActivityActivity.CONSTRAINTS"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_view_activity)
    }
}