package com.github.wassilkhetim.android4a.presentation.body

sealed class LoadDataStatus

data class DataLoaded(val msg:String): LoadDataStatus()
data class DataNotLoaded(val err:String): LoadDataStatus()