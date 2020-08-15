package com.cresonnglobal.mdcp.widgets.date_time

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TextView
import com.cresonnglobal.mdcp.R
import com.cresonnglobal.mdcp.data.question.Question

class DateTimeFragment(val question: Question) : Fragment() {

    companion object {
//        fun newInstance() = DateTimeFragment(question)
    }

    private lateinit var viewModel: DateTimeViewModel
    private lateinit var nameTextView: TextView
    private lateinit var labelTextView: TextView
    private lateinit var hintTextView: TextView
    private lateinit var datePicker: DatePicker

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.date_time_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DateTimeViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameTextView = view.findViewById(R.id.name)
        labelTextView  = view.findViewById(R.id.label)
        hintTextView  = view.findViewById(R.id.hint)

        nameTextView.text = question.name
        labelTextView.text = question.label
        hintTextView.text = question.hint
    }
}