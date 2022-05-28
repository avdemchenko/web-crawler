package com.avdemchenko.webcrawler.selenium

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import javax.annotation.PostConstruct

@Configuration
class SeleniumWebDriverConfiguration {

    @PostConstruct
    fun init() = WebDriverManager.chromedriver().setup()

    @Bean
    @JobScope
    fun getDriver() = ChromeDriver()

}
