package com.azabost.wm.bug.sample.di

import dagger.Module
import dagger.Provides
import java.util.UUID

@Module
class FakeDataModule {

    @Provides
    fun providesFakeData(): String = UUID.randomUUID().toString()
}