package com.azabost.wm.bug.sample.work.di

import com.azabost.wm.bug.sample.work.WorkManagerConfigurator
import com.azabost.wm.bug.sample.work.WorkManagerInjectingFactoryConfigurator
import dagger.Binds
import dagger.Module

@Module
interface WorkManagerBindingModule {
    @Binds
    fun bindWorkManagerConfigurator(initializer: WorkManagerInjectingFactoryConfigurator): WorkManagerConfigurator
}