package com.avdemchenko.webcrawler.batch.facebook.screenplay.login

import org.openqa.selenium.By

data class LoginPage(
    val content: By = By.id("content"),
    val email: By = By.id("email"),
    val password: By = By.id("pass"),
    val loginButton: By = By.name("login")
)
