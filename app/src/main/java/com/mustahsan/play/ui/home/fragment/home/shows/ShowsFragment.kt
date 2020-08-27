package com.mustahsan.play.ui.home.fragment.home.shows

import android.content.Context
import android.os.Bundle
import android.transition.Slide
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import com.google.gson.Gson
import com.mustahsan.androidkit.log.logI
import com.mustahsan.play.R
import com.mustahsan.play.model.DataSet
import com.mustahsan.play.ui.home.fragment.home.ContentFragment
import com.mustahsan.play.ui.home.fragment.search.SearchViewModel
import kotlinx.android.synthetic.main.fragment_shows.*
import java.io.IOException
import java.io.InputStream

class ShowsFragment : ContentFragment() {

    private lateinit var viewModel: SearchViewModel
    private var data = MutableLiveData<DataSet>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)
        return inflater.inflate(R.layout.fragment_shows, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        data.observe(viewLifecycleOwner, {
            imageSlider.setSliderAdapter(SliderAdapter(it.titles))
            imageSlider .startAutoCycle();

            popularMoviesSv.setData("Popular Movies", it.titles.toMutableList().apply { shuffle() })
            popularTvSv.setData("Popular Tv Shows", it.titles.toMutableList().apply { shuffle() })
            trendingTvSv.setData("Trending", it.titles.toMutableList().apply { shuffle() })
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        loadJSONFromAsset()?.let { json ->
            val data = Gson().fromJson(json, DataSet::class.java)
            logI("$data")
            loadData(data)
        }
    }

    fun loadJSONFromAsset(): String? {
        var json: String? = null
        json = try {
            val `is`: InputStream = requireActivity().assets.open("homepage.json")
            val size: Int = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            String(buffer, charset("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }

    override fun loadData(dataSet: DataSet) {
        data.postValue(dataSet)
    }

    companion object {
        fun getInstance() =
            ShowsFragment()
    }
}