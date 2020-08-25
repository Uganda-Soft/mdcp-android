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
    private lateinit var onQuestionClickListener: OnQuestionClickListener;

    init {
        onQuestionClickListener = context as OnQuestionClickListener
    }

    class QuestionViewHolder(
        itemView: View,
        private val onQuestionClickListener: OnQuestionClickListener
    ): RecyclerView.ViewHolder(itemView) {
        private val numberTextView: TextView = itemView.findViewById(R.id.question_number)
        private val labelTextView: TextView = itemView.findViewById(R.id.question_label)
        private val statusTextView: View = itemView.findViewById(R.id.question_status)

        public fun bind(number: Int, question: Question) {
            val displayNumber: String = if (number < 9) { "0${number + 1}" } else { (number + 1).toString() }
            numberTextView.text = displayNumber
            labelTextView.text = question.name
//            statusTextView.text = "something"
            itemView.setOnClickListener {
                onQuestionClickListener.onQuestionClick(question)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.question_list_item, parent, false)
        return QuestionViewHolder(view, onQuestionClickListener)
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val question: Question = questions[position]
        holder.bind(position, question)
    }

    public interface OnQuestionClickListener {
        public fun onQuestionClick(question: Question)
    }
}