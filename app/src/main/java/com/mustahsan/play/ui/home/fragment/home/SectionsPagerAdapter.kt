package com.mustahsan.play.ui.home.fragment.home

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.mustahsan.play.model.DataSet

class SectionsPagerAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val titles = arrayListOf<String>()
    private val fragments = arrayListOf<ContentFragment>()

    fun addPage(title: String, fragment: ContentFragment) {
        titles.add(title)
        fragments.add(fragment)
    }

    fun loadData(data: DataSet) {
        for (fragment in fragments) {
            fragment.loadData(data)
        }
    }

    override fun getItem(position: Int): ContentFragment {
        return fragments[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }

    override fun getCount(): Int {
        return titles.size
    }
}