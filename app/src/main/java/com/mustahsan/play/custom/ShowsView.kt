package com.mustahsan.play.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.mustahsan.androidkit.recyclerview.DataBoundRecyclerAdapter
import com.mustahsan.androidkit.recyclerview.itemSpacing
import com.mustahsan.play.R
import com.mustahsan.play.databinding.ItemShowsBinding
import com.mustahsan.play.model.Show
import kotlinx.android.synthetic.main.view_shows.view.*

class ShowsView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    constructor(context: Context, title: String, data: MutableList<Show>) : this(context) {
        this.title = title
        this.data = data
    }

    private var title: String = ""
    private var data: MutableList<Show> = mutableListOf()

    private lateinit var adapter: ShowsAdapter

    init {
        View.inflate(context, R.layout.view_shows, this)
        recyclerView.itemSpacing(resources.getDimension(R.dimen.space_item_show).toInt(), true)
        adapter = ShowsAdapter()
        recyclerView.adapter = adapter
        setData(title, data)
    }

    fun setData(title: String, data: MutableList<Show>) {
        titleTextView.text = title
        adapter.data = data
        this.title = title
        this.data = data
    }


    class ShowsAdapter : DataBoundRecyclerAdapter<Show, ItemShowsBinding>() {
        override fun bind(binding: ItemShowsBinding, item: Show, position: Int) {
            binding.show = item
        }

        override fun createBinding(parent: ViewGroup): ItemShowsBinding {
            return DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_shows,
                parent,
                false
            )
        }

    }

}

