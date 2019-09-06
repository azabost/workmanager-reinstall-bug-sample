package com.azabost.wm.bug.sample.work

import android.content.Context
import androidx.work.*
import com.azabost.wm.bug.sample.log
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class WorkSchedulerWorkManager @Inject constructor(
    private val context: Context
) : WorkScheduler {

    override fun enqueueWork() {
        log.debug("Enqueueing work with name: $WORK_TASK_UNIQUE_NAME and tag: $WORK_TASK_TAG")
        val workManager = WorkManager.getInstance(context)

        val workRequest = OneTimeWorkRequestBuilder<SampleWorker>()
            .addTag(WORK_TASK_TAG)
            .setConstraints(
                Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build()
            )
            .setBackoffCriteria(BackoffPolicy.LINEAR, WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS)
            .build()

        workManager
            .beginUniqueWork(WORK_TASK_UNIQUE_NAME, ExistingWorkPolicy.KEEP, workRequest)
            .enqueue()
    }

    override fun resetWork() {
        log.debug("Resetting schedule - cancelling unique work (name: $WORK_TASK_UNIQUE_NAME)")
        WorkManager.getInstance(context).cancelUniqueWork(WORK_TASK_UNIQUE_NAME)
        log.debug("Resetting schedule - enqueueing a new work")
        enqueueWork()
    }

    companion object {
        private const val WORK_TASK_TAG = "WORK_TAG"
        private const val WORK_TASK_UNIQUE_NAME = "WORK_NAME"
    }
}