package com.mustahsan.play.ui.home.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.mustahsan.play.R
import com.mustahsan.play.custom.ShowsView
import com.mustahsan.play.model.DataSet
import com.mustahsan.play.model.Show
import com.mustahsan.play.ui.home.fragment.search.SearchViewModel
import kotlinx.android.synthetic.main.fragment_shows.*

abstract class ContentFragment : Fragment() {
    abstract fun loadData(dataSet: DataSet)
}