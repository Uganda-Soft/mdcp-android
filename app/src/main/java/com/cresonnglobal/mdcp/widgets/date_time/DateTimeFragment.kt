package com.cresonnglobal.mdcp.widgets.date_time

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cresonnglobal.mdcp.R

class DateTimeFragment : Fragment() {

    companion object {
        fun newInstance() = DateTimeFragment()
    }

    private lateinit var viewModel: DateTimeViewModel

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

}