package com.cresonnglobal.mdcp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuestionAdapter {
    class QuestionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val numberTextView: TextView = itemView.findViewById(R.id.question_number)
        private val labelTextView: TextView = itemView.findViewById(R.id.question_label)
        private val statusTextView: TextView = itemView.findViewById(R.id.question_status)
    }
}