package com.avdemchenko.webcrawler.batch

import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParameters
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.stereotype.Service

@Service
class SpringBatchJobService(
    private val asyncLauncher: JobLauncher,
    private val someJob: Job,
) {

    fun launchJob() {
        asyncLauncher.run(someJob, JobParameters())
    }
}
