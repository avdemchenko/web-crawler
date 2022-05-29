package com.avdemchenko.webcrawler.batch.facebook.screenplay.login

import org.openqa.selenium.WebDriver
import org.springframework.stereotype.Component

@Component
class LoginStepDefinition(webDriver: WebDriver) {

    private val loginStep = LoginStep(webDriver)

    fun performLogin() {
        loginStep.waitForPageToBeLoaded()
        loginStep.provideEmail("test")
        loginStep.providePassword("pass")
        loginStep.clickLoginButton()
    }
}
