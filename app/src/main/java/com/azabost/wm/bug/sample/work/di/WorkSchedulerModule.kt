package com.azabost.wm.bug.sample.work.di

import com.azabost.wm.bug.sample.work.WorkScheduler
import com.azabost.wm.bug.sample.work.WorkSchedulerWorkManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class WorkSchedulerModule {

    @Provides
    @Singleton
    fun providesWorkScheduler(impl: WorkSchedulerWorkManager): WorkScheduler = impl
}