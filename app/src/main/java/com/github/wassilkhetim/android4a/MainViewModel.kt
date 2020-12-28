package com.github.wassilkhetim.android4a

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val counter: MutableLiveData<Int> = MutableLiveData()

    init {
        counter.value = 0
    }

    fun onIncrement() {
        counter.value = (counter.value?:0) + 1
    }

}
