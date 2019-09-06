package com.azabost.wm.bug.sample.di

import com.azabost.wm.bug.sample.MainActivity
import dagger.Module

@Module(
    includes = [
        MainActivity.InjectorModule::class
    ]
)
class AndroidInjectorsModule