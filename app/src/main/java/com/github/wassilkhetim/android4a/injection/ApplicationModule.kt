package com.github.wassilkhetim.android4a.injection

import com.github.wassilkhetim.android4a.MainViewModel
import org.koin.dsl.module

val presentationModule = module{
    factory { MainViewModel() }
}