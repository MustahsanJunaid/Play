package com.mustahsan.play.ui.home.fragment.home.shows


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.mustahsan.play.R
import com.mustahsan.play.databinding.ItemShowsBinding
import com.mustahsan.play.model.Show
import com.smarteist.autoimageslider.SliderViewAdapter


class SliderAdapter(val items: List<Show>) :
    SliderViewAdapter<SliderAdapter.ViewHolder>() {

    override fun getCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        val binding: ItemShowsBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent?.context),
            R.layout.item_shows,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder?, position: Int) {
        viewHolder?.binding?.show = items[position]
    }

    class ViewHolder(val binding: ItemShowsBinding) : SliderViewAdapter.ViewHolder(binding.root)
}