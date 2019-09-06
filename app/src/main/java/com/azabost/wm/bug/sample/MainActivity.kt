package com.azabost.wm.bug.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.azabost.wm.bug.sample.work.WorkScheduler
import dagger.Module
import dagger.android.AndroidInjection
import dagger.android.ContributesAndroidInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var workScheduler: WorkScheduler

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enqueueWork.setOnClickListener {
            log.debug("Enqueue button clicked")
            workScheduler.enqueueWork()
        }
    }

    @Module
    interface InjectorModule {
        @ContributesAndroidInjector
        fun contributeMainActivity(): MainActivity
    }
}
