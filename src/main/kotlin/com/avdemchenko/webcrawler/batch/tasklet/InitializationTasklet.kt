package com.avdemchenko.webcrawler.batch.tasklet

import mu.KLogging
import org.openqa.selenium.WebDriver
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@StepScope
@Component
class InitializationTasklet(@Autowired val webDriver: WebDriver) : Tasklet {

    override fun execute(stepContribution: StepContribution, chunkContext: ChunkContext): RepeatStatus {
        logger.debug { "test initialize" }

        webDriver.navigate().to("https://www.google.com.ua/?hl=ru")
        return RepeatStatus.FINISHED
    }

    companion object: KLogging()
}
