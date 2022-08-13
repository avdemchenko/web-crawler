package com.avdemchenko.webcrawler.batch.opensea.screenplay.home

import org.springframework.stereotype.Component

@Component
class HomeStepDefinition(private val homePage: HomePage) {

    fun navigateToHomePage() {
        homePage.run {
            open()
            waitForPageToBeLoaded()
        }
    }

    fun goToRankings() {
        homePage.goToRankings()
    }
}
