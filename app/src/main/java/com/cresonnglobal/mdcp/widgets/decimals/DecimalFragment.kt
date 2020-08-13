package com.cresonnglobal.mdcp.widgets.decimals

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cresonnglobal.mdcp.R

class DecimalFragment : Fragment() {

    companion object {
        fun newInstance() = DecimalFragment()
    }

    private lateinit var viewModel: DecimalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.decimal_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DecimalViewModel::class.java)
        // TODO: Use the ViewModel
    }

}