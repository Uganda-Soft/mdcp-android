package com.cresonnglobal.mdcp.widgets.text

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.cresonnglobal.mdcp.R
import com.cresonnglobal.mdcp.data.question.Question

class TextFragment(val question: Question) : Fragment() {

    private lateinit var viewModel: TextViewModel
    private lateinit var nameTextView: TextView
    private lateinit var labelTextView: TextView
    private lateinit var hintTextView: TextView
    private lateinit var answerEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.text_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TextViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameTextView = view.findViewById(R.id.name)
        labelTextView  = view.findViewById(R.id.name)
        hintTextView  = view.findViewById(R.id.hint)
        answerEditText = view.findViewById(R.id.answer)

        nameTextView.text = question.name
        labelTextView.text = question.label
        hintTextView.text = question.hint
    }
}