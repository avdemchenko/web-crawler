package com.avdemchenko.webcrawler.batch.opensea.screenplay.rankings

import org.springframework.stereotype.Component

@Component
class RankingsStepDefinition(private val rankingsPage: RankingsPage) {

    fun items() {
        rankingsPage.run {
            waitForPageToBeLoaded()
            getItems()
        }
    }
}
