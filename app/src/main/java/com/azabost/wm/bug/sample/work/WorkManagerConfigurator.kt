package com.azabost.wm.bug.sample.work

import androidx.work.Configuration

interface WorkManagerConfigurator {
    fun getConfiguration(): Configuration
}
