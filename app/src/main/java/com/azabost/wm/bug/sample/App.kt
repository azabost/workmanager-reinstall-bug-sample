package com.azabost.wm.bug.sample

import android.app.Activity
import androidx.work.Configuration
import com.azabost.wm.bug.sample.di.DaggerAppComponent
import com.azabost.wm.bug.sample.work.WorkScheduler
import com.azabost.wm.bug.sample.work.WorkManagerConfigurator
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

class App : DaggerApplication(), Configuration.Provider {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var workManagerConfigurator: WorkManagerConfigurator

    @Inject
    lateinit var workScheduler: WorkScheduler

    override fun getWorkManagerConfiguration(): Configuration = workManagerConfigurator.getConfiguration()

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()

        // Workaround #1: uncomment this line
        // workScheduler.resetWork()
    }
}