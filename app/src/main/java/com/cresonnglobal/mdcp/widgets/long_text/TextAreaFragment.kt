package com.cresonnglobal.mdcp.widgets.long_text

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cresonnglobal.mdcp.R

class TextAreaFragment : Fragment() {

    companion object {
        fun newInstance() = TextAreaFragment()
    }

    private lateinit var viewModel: TextAreaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.text_area_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TextAreaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}