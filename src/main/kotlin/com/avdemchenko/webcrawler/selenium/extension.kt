package com.avdemchenko.webcrawler.selenium

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

fun WebDriver.waitUntilElementIsVisible(element: By): WebElement =
    WebDriverWait(this, Duration.ofSeconds(30))
        .until(visibilityOfElementLocated(element))
