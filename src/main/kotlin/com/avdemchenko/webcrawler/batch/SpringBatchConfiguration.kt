package com.avdemchenko.webcrawler.batch

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableBatchProcessing
class SpringBatchConfig(
    val jobs: JobBuilderFactory,
    val steps: StepBuilderFactory,
) {

    @Bean
    fun someJob(
        initialize: Step
    ): Job =
        jobs["gamingActivityReport"]
            .start(initialize)
            .build()

    @Bean
    @JobScope
    fun initialize(initializationTasklet: Tasklet) =
        steps["initialize"]
            .tasklet(initializationTasklet)
            .allowStartIfComplete(true)
            .build()
}
