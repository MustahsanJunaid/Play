package com.mustahsan.play.ui.home.fragment.home.kids

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.mustahsan.play.R
import com.mustahsan.play.model.DataSet
import com.mustahsan.play.ui.home.fragment.home.ContentFragment
import com.mustahsan.play.ui.home.fragment.search.SearchViewModel

class KidsFragment : ContentFragment() {

    private lateinit var viewModel: SearchViewModel
    override fun loadData(dataSet: DataSet) {

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)
        return inflater.inflate(R.layout.fragment_kids, container, false)
    }

    companion object {
        fun getInstance() =
            KidsFragment()
    }
}