package com.azabost.wm.bug.sample.di

import com.azabost.wm.bug.sample.App
import com.azabost.wm.bug.sample.work.di.WorkModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidInjectorsModule::class,
        AppModule::class,
        WorkModule::class,
        FakeDataModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Factory
    interface Factory : AndroidInjector.Factory<App>
}