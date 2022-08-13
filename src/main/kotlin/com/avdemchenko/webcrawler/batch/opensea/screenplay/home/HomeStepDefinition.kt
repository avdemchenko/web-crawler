package com.avdemchenko.webcrawler.batch.opensea.screenplay.home

import com.avdemchenko.webcrawler.config.SeleniumProperties
import org.springframework.stereotype.Component
import kotlin.reflect.full.NoSuchPropertyException

@Component
class HomeStepDefinition(
    private val homeStep: HomeStep,
    private val props: SeleniumProperties,
) {

    fun navigateToHomePage() {
        val url = props.targets["opensea"] ?: throw NoSuchPropertyException()
        homeStep.openHomePage(url)
        homeStep.waitForPageToBeLoaded()
    }

    fun goToRankings() {
        homeStep.openRankings()
    }
}
