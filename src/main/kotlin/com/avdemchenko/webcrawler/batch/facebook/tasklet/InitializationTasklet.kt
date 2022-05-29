package com.avdemchenko.webcrawler.batch.facebook.tasklet

import com.avdemchenko.webcrawler.config.SeleniumProperties
import mu.KLogging
import org.openqa.selenium.WebDriver
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.stereotype.Component

@StepScope
@Component
class InitializationTasklet(val webDriver: WebDriver, val props: SeleniumProperties) : Tasklet {

    override fun execute(stepContribution: StepContribution, chunkContext: ChunkContext): RepeatStatus {
        logger.debug { "Webdriver: $webDriver has been initialized" }
        webDriver.navigate().to(props.targets["facebook"])
        return RepeatStatus.FINISHED
    }

    companion object: KLogging()
}
