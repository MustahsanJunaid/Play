package com.mustahsan.play.ui.home.fragment.mylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mustahsan.play.R
import kotlinx.android.synthetic.main.fragment_my_list.*

class MyListFragment : Fragment() {

    private lateinit var viewModel: MyListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(MyListViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_my_list, container, false)
        viewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}