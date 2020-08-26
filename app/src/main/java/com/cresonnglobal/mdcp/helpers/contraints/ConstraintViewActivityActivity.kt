package com.cresonnglobal.mdcp.helpers.contraints

import android.app.Activity
import android.os.Bundle
import com.cresonnglobal.mdcp.R
import kotlinx.android.synthetic.main.activity_constraint_view_activity.*

class ConstraintViewActivityActivity : Activity() {
    companion object {
        public final const val CONSTRAINTS = "com.cresonnglobal.mdcp.helpers.contraints.ConstraintViewActivityActivity.CONSTRAINTS"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_view_activity)

        val intent = intent
        val constraintMessages:Array<String>? = intent.getStringArrayExtra(CONSTRAINTS)
        var message:String = ""
        if (constraintMessages != null) {
            for (messageText: String in constraintMessages) {
                message = message + messageText + "\n"
            }

        } else {
            message = "No Constraint Message Found"
        }

        constraints_message.text = message
    }
}