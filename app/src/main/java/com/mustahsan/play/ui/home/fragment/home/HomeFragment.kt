package com.mustahsan.play.ui.home.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.mustahsan.play.R
import com.mustahsan.play.ui.home.fragment.home.kids.KidsFragment
import com.mustahsan.play.ui.home.fragment.home.movies.MoviesFragment
import com.mustahsan.play.ui.home.fragment.home.shows.ShowsFragment
import com.mustahsan.play.ui.home.fragment.home.tv.TvShowsFragment
import com.mustahsan.play.ui.home.fragment.home.urdu.UrduFragment
import com.mustahsan.play.ui.home.fragment.home.yupflix.YupFlixFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    private val pagerAdapter by lazy {
        SectionsPagerAdapter(childFragmentManager).apply {
            addPage("Home", ShowsFragment.getInstance())
            addPage("Movies", MoviesFragment.getInstance())
            addPage("Tv Shows", TvShowsFragment.getInstance())
            addPage("Urdu", UrduFragment.getInstance())
            addPage("Yupflix", YupFlixFragment.getInstance())
            addPage("Kids", KidsFragment.getInstance())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager.adapter = pagerAdapter
        tabs.setupWithViewPager(viewPager)

    }

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        loadJSONFromAsset()?.let { json ->
//            val data = Gson().fromJson(json, DataSet::class.java)
//            logI("$data")
//            pagerAdapter.loadData(data)
//        }
//    }
//
//    fun loadJSONFromAsset(): String? {
//        var json: String? = null
//        json = try {
//            val `is`: InputStream = requireActivity().assets.open("homepage.json")
//            val size: Int = `is`.available()
//            val buffer = ByteArray(size)
//            `is`.read(buffer)
//            `is`.close()
//            String(buffer, charset("UTF-8"))
//        } catch (ex: IOException) {
//            ex.printStackTrace()
//            return null
//        }
//        return json
//    }
}