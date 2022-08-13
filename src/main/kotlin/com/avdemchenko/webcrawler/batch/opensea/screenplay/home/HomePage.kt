package com.avdemchenko.webcrawler.batch.opensea.screenplay.home

import org.openqa.selenium.By
import org.springframework.stereotype.Component

@Component
data class HomePage(
    val main: By = By.id("main"),
    val goToRankingsButton: By = By.cssSelector("a[href*='rankings']"),
)
