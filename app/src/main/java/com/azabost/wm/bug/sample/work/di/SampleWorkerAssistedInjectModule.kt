package com.azabost.wm.bug.sample.work.di

import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module

@Module(includes = [AssistedInject_SampleWorkerAssistedInjectModule::class])
@AssistedModule
interface SampleWorkerAssistedInjectModule