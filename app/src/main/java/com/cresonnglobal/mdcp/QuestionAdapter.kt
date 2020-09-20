package com.cresonnglobal.mdcp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cresonnglobal.mdcp.data.question.Question

class QuestionAdapter(var Questions: List<Question>, val context: Context):
    RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {
    private var onQuestionClickListener: OnQuestionClickListener;

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

        public fun bind(number: Int, Question: Question) {
            val displayNumber: String = if (number < 9) { "0${number + 1}" } else { (number + 1).toString() }
            numberTextView.text = displayNumber
//            labelTextView.text = Question.name
//            statusTextView.text = "something"
            itemView.setOnClickListener {
                onQuestionClickListener.onQuestionClick(Question, number)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.question_list_item, parent, false)
        return QuestionViewHolder(view, onQuestionClickListener)
    }

    override fun getItemCount(): Int {
        return Questions.size
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val Question: Question = Questions[position]
        holder.bind(position, Question)
    }

    public interface OnQuestionClickListener {
        public fun onQuestionClick(question: Question, number: Int)
    }
}