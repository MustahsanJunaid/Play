package com.mustahsan.play.ui.home.fragment.mylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyListViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is My List Fragment"
    }
    val text: LiveData<String> = _text
}