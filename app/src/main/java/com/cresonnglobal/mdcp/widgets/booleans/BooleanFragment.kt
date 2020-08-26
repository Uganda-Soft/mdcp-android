package com.cresonnglobal.mdcp.widgets.booleans

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.cresonnglobal.mdcp.R
import com.cresonnglobal.mdcp.data.question.Question

class BooleanFragment(val question: Question) : Fragment() {


    private lateinit var viewModel: BooleanViewModel
    private lateinit var nameTextView: TextView
    private lateinit var labelTextView: TextView
    private lateinit var hintTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.boolean_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BooleanViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameTextView = view.findViewById(R.id.name)
        labelTextView  = view.findViewById(R.id.name)
        hintTextView  = view.findViewById(R.id.hint)

        nameTextView.text = question.name
        labelTextView.text = question.label
        hintTextView.text = question.hint
    }

}