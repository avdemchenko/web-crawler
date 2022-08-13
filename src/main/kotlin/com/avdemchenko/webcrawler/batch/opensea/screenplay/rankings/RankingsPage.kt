package com.avdemchenko.webcrawler.batch.opensea.screenplay.rankings

import com.avdemchenko.webcrawler.selenium.waitUntilElementIsVisible
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.springframework.stereotype.Component

@Component
class RankingsPage(private val webDriver: WebDriver) {

    fun getItems() = webDriver.findElements(By.cssSelector(LIST_ITEM_CSS))

    fun waitForPageToBeLoaded() =
        webDriver.waitUntilElementIsVisible(By.cssSelector(LIST_CONTAINER_CSS))

    companion object {
        const val LIST_CONTAINER_CSS = "[role = 'list']"
        const val LIST_ITEM_CSS = "[role = 'listitem']"
    }
}
