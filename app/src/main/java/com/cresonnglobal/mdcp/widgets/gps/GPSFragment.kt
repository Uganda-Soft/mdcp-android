package com.cresonnglobal.mdcp.widgets.gps

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cresonnglobal.mdcp.R

class GPSFragment : Fragment() {

    companion object {
        fun newInstance() = GPSFragment()
    }

    private lateinit var viewModel: GPSViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.g_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GPSViewModel::class.java)
        // TODO: Use the ViewModel
    }

}