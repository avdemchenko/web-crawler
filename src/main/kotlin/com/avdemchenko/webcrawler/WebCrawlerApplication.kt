package com.avdemchenko.webcrawler

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class WebCrawlerApplication

fun main(args: Array<String>) {
    runApplication<WebCrawlerApplication>(*args)
}
