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
        initialize: Step,
        scrap: Step,
        cleanup: Step
    ): Job =
        jobs["opensea"]
            .start(initialize)
            .next(scrap)
            .next(cleanup)
            .build()

    @Bean
    @JobScope
    fun initialize(initializationTasklet: Tasklet) =
        steps["initialize"]
            .tasklet(initializationTasklet)
            .allowStartIfComplete(true)
            .build()
    @Bean
    @JobScope
    fun scrap(scrapperTasklet: Tasklet) =
        steps["scrapperTasklet"]
            .tasklet(scrapperTasklet)
            .allowStartIfComplete(true)
            .build()

    @Bean
    @JobScope
    fun cleanup(cleanupTasklet: Tasklet) =
        steps["cleanup"]
            .tasklet(cleanupTasklet)
            .allowStartIfComplete(true)
            .build()
}
