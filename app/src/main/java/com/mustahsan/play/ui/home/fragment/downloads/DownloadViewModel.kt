package com.mustahsan.play.ui.home.fragment.downloads

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DownloadViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Download Fragment"
    }
    val text: LiveData<String> = _text
}