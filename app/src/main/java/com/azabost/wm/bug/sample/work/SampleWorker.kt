package com.azabost.wm.bug.sample.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.azabost.wm.bug.sample.log
import com.azabost.wm.bug.sample.work.di.ChildWorkerFactory
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors

class SampleWorker @AssistedInject constructor(
    @Assisted private val appContext: Context,
    @Assisted private val params: WorkerParameters,
    private val fakeData: String
) : CoroutineWorker(appContext, params) {

    @AssistedInject.Factory
    interface Factory : ChildWorkerFactory

    companion object {
        private val dispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()
    }

    private val workId = params.id

    override suspend fun doWork(): Result {
        log.debug("Starting work ID = $workId")

        return withContext(dispatcher) {
            log.debug("[$workId] Entered suspending block")

            try {
                process()
                Result.success()
            } catch (e: Exception) {
                log.error("[$workId] Unhandled exception", e)
                Result.retry()
            }
        }
    }

    private suspend fun process() {
        log.debug("Processing started")
        delay(1000)
        throw RuntimeException("Test exception")
        log.debug("Processing finished")
    }
}