package com.avdemchenko.webcrawler.batch.opensea.screenplay.home

import com.avdemchenko.webcrawler.selenium.waitUntilElementIsVisible
import org.openqa.selenium.WebDriver
import org.springframework.stereotype.Component

@Component
class HomeStep(
    private val webDriver: WebDriver,
    private val homePage: HomePage,
) {

    fun openHomePage(url: String) =
        webDriver.navigate().to(url)

    fun waitForPageToBeLoaded() =
        webDriver.waitUntilElementIsVisible(homePage.main)

    fun openRankings() =
        webDriver.findElement(homePage.goToRankingsButton).click()
}
