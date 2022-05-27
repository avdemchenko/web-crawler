package com.avdemchenko.webcrawler.rest

import com.avdemchenko.webcrawler.batch.SpringBatchJobService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class WebCrawlerResource(
    private val springBatchJobService: SpringBatchJobService
) {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/run")
    fun getRunningReports() =
        springBatchJobService.launchJob()
}
