package com.azabost.wm.bug.sample.work.di

import dagger.Module

@Module(
    includes = [
        WorkSchedulerModule::class,
        SampleWorkerAssistedInjectModule::class,
        SampleWorkerBindingModule::class,
        WorkManagerBindingModule::class
    ]
)
class WorkModule