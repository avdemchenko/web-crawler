package com.avdemchenko.webcrawler.batch.opensea.screenplay.home

import com.avdemchenko.webcrawler.config.SeleniumProperties
import com.avdemchenko.webcrawler.selenium.waitUntilElementIsVisible
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.springframework.stereotype.Component
import kotlin.reflect.full.NoSuchPropertyException

@Component
class HomePage(private val webDriver: WebDriver, private val props: SeleniumProperties) {

    fun open() =
        webDriver.navigate().to(props.targets["opensea"] ?: throw NoSuchPropertyException())

    fun goToRankings() =
        webDriver.findElement(By.cssSelector(GO_TO_RANKINGS_BUTTON_CSS)).click()

    fun waitForPageToBeLoaded() =
        webDriver.waitUntilElementIsVisible(By.cssSelector(MAIN_CONTAINER_CSS))

    companion object {
        const val MAIN_CONTAINER_CSS = "main"
        const val GO_TO_RANKINGS_BUTTON_CSS = "a[href*='rankings']"
    }
}
