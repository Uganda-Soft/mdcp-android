package com.cresonnglobal.mdcp.widgets.booleans

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cresonnglobal.mdcp.R

class BooleanFragment : Fragment() {

    companion object {
        fun newInstance() = BooleanFragment()
    }

    private lateinit var viewModel: BooleanViewModel

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

}