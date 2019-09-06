package com.azabost.wm.bug.sample.work

import android.util.Log
import androidx.work.Configuration
import com.azabost.wm.bug.sample.work.di.InjectingWorkerFactory
import javax.inject.Inject

class WorkManagerInjectingFactoryConfigurator @Inject constructor(
    private val factory: InjectingWorkerFactory
) : WorkManagerConfigurator {

    override fun getConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(factory)
            .setMinimumLoggingLevel(Log.VERBOSE)
            .build()
    }
}