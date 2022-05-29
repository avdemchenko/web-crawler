package com.avdemchenko.webcrawler.batch.facebook.tasklet

import com.avdemchenko.webcrawler.batch.facebook.screenplay.login.LoginStepDefinition
import mu.KLogging
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.stereotype.Component

@StepScope
@Component
class ScrapperTasklet(val loginStepDefinition: LoginStepDefinition) : Tasklet {

    override fun execute(stepContribution: StepContribution, chunkContext: ChunkContext): RepeatStatus {
        loginStepDefinition.performLogin()
        return RepeatStatus.FINISHED
    }

    companion object: KLogging()
}
