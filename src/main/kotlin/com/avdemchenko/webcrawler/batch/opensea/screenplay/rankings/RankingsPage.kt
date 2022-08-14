package com.avdemchenko.webcrawler.batch.opensea.screenplay.rankings

import com.avdemchenko.webcrawler.selenium.waitUntilElementIsVisible
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class RankingsPage(private val webDriver: WebDriver) {

    fun getItems() = webDriver.findElements(By.cssSelector(RANKING_ITEM_CSS))
        .map {
            RankingItem(
                name = it.findElement(By.cssSelector(RANKING_ITEM_NAME_CSS)).text,
                volume = it.findElement(By.cssSelector(VOLUME_CSS)).text
                    .replace(" ", "")
                    .replace(",", ".")
                    .toBigDecimalOrNull() ?: BigDecimal.ZERO,
                currency = it.findElement(By.cssSelector(VOLUME_CURRENCY_CSS))
                    .getAttribute("aria-label")
                    .removeSuffix(" logo"),
                twentyFourHoursChange = it.findElement(By.cssSelector(TWENTY_FOUR_HOURS_CHANGE_CSS)).text
                    .removeSuffix("%")
                    .toBigDecimalOrNull() ?: BigDecimal.ZERO,
                sevenDaysChange = it.findElement(By.cssSelector(SEVEN_DAYS_CHANGE_CSS)).text
                    .removeSuffix("%")
                    .toBigDecimalOrNull() ?: BigDecimal.ZERO,
                floorPrice = it.findElement(By.cssSelector(FLOOR_PRICE_CSS)).text
                    .toBigDecimalOrNull() ?: BigDecimal.ZERO,
                owners = it.findElement(By.cssSelector(OWNERS_CSS)).text.calculateAmount(),
                items = it.findElement(By.cssSelector(ITEMS_CSS)).text.calculateAmount(),
            )
        }

    fun waitForPageToBeLoaded() =
        webDriver.waitUntilElementIsVisible(By.cssSelector(RANKING_ITEM_NAME_CSS))

    private fun String.calculateAmount(): BigDecimal =
        when {
            this.contains("K") -> this.removeSuffix("K").toBigDecimal().times(BigDecimal("1000"))
            this.contains("M") -> this.removeSuffix("M").toBigDecimal().times(BigDecimal("1000000"))
            else -> this.toBigDecimalOrNull() ?: BigDecimal.ZERO
        }

    companion object {
        const val RANKING_ITEM_CSS = "[role = 'listitem']"
        const val RANKING_ITEM_NAME_CSS = ".Ranking--collection-name-overflow"
        const val VOLUME_CSS = ".sc-1xf18x6-0.sc-1aqfqq9-0.sc-12irlp3-3.jIFPFr.gluLLh"
        const val VOLUME_CURRENCY_CSS = ".sc-ty1bh0-0.infdiL"
        const val TWENTY_FOUR_HOURS_CHANGE_CSS = ".sc-1xf18x6-0.sc-1twd32i-0.cTvSkV.kKpYwv"
        const val SEVEN_DAYS_CHANGE_CSS = ".sc-1xf18x6-0.sc-1twd32i-0.haVRLx.kKpYwv"
        const val FLOOR_PRICE_CSS = "a > div:nth-child(5) > div > span > div"
        const val OWNERS_CSS = "a > div:nth-child(6) > p"
        const val ITEMS_CSS = "a > div:nth-child(7) > p"
    }
}
