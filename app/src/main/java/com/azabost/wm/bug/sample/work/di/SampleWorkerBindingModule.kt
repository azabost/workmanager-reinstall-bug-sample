package com.azabost.wm.bug.sample.work.di

import com.azabost.wm.bug.sample.work.SampleWorker
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface SampleWorkerBindingModule {
    @Binds
    @IntoMap
    @WorkerKey(SampleWorker::class)
    fun bindSampleWorkerFactory(factory: SampleWorker.Factory): ChildWorkerFactory
}