package com.avdemchenko.webcrawler.batch.facebook.screenplay.login

import com.avdemchenko.webcrawler.selenium.waitUntilElementIsVisible
import org.openqa.selenium.WebDriver

class LoginStep(
    private val webDriver: WebDriver,
    private val loginPage: LoginPage = LoginPage()
) {

    fun waitForPageToBeLoaded() =
        webDriver.waitUntilElementIsVisible(loginPage.content)

    fun provideEmail(email: String) =
        webDriver.findElement(loginPage.email).sendKeys(email)

    fun providePassword(password: String) =
        webDriver.findElement(loginPage.password).sendKeys(password)

    fun clickLoginButton() =
        webDriver.findElement(loginPage.loginButton).click()
}
