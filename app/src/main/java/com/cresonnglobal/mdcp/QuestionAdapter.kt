package com.cresonnglobal.mdcp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cresonnglobal.mdcp.data.question.Question

class QuestionAdapter(var questions: List<Question>, val context: Context):
    RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {

    class QuestionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val numberTextView: TextView = itemView.findViewById(R.id.question_number)
        private val labelTextView: TextView = itemView.findViewById(R.id.question_label)
        private val statusTextView: View = itemView.findViewById(R.id.question_status)

        public fun bind(number: Int, question: Question) {
            numberTextView.text = (number + 1).toString()
            labelTextView.text = question.name
//            statusTextView.text = "something"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.question_list_item, parent, false)
        return QuestionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val question: Question = questions[position]
        holder.bind(position, question)
    }
}