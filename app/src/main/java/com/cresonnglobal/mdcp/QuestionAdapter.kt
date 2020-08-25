package com.cresonnglobal.mdcp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cresonnglobal.mdcp.data.question.Question

class QuestionAdapter {
    class QuestionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val numberTextView: TextView = itemView.findViewById(R.id.question_number)
        private val labelTextView: TextView = itemView.findViewById(R.id.question_label)
        private val statusTextView: View = itemView.findViewById(R.id.question_status)

        public fun bind(number: Int, question: Question) {
            numberTextView.text = number.toString()
            labelTextView.text = question.label
//            statusTextView.text = "something"
        }
    }
}