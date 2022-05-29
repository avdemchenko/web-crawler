package com.avdemchenko.webcrawler.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(SeleniumProperties::class)
class CrawlerPropertiesConfig

@ConstructorBinding
@ConfigurationProperties("selenium")
data class SeleniumProperties(
    val browser: String,
    val targets: Map<String, String>
)
