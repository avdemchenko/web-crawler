package com.avdemchenko.webcrawler.selenium

import com.avdemchenko.webcrawler.config.SeleniumProperties
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SeleniumWebDriverConfiguration(val props: SeleniumProperties) {

    @Bean
    @JobScope
    fun getDriver(): ChromeDriver {
        when (props.browser) {
            "chrome" -> {
                WebDriverManager.chromedriver().setup()
                return ChromeDriver()
            }
            else -> throw IllegalAccessException()
        }
    }
}
