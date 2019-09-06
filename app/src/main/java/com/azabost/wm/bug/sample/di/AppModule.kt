package com.azabost.wm.bug.sample.di

import android.content.Context
import com.azabost.wm.bug.sample.App
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        ContextModule::class
    ]
)
class AppModule

@Module
interface ContextModule {
    @Binds
    fun bindContext(app: App): Context
}