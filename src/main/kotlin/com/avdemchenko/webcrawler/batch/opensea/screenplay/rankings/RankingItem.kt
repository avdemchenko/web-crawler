package com.avdemchenko.webcrawler.batch.opensea.screenplay.rankings

import java.math.BigDecimal

data class RankingItem(
    val rankingPosition: BigDecimal = BigDecimal.ZERO,
    val name: String = "",
    val volume: BigDecimal = BigDecimal.ZERO,
    val currency: String = "",
    val twentyFourHoursChange: BigDecimal = BigDecimal.ZERO,
    val sevenDaysChange: BigDecimal = BigDecimal.ZERO,
    val floorPrice: BigDecimal = BigDecimal.ZERO,
    val owners: BigDecimal = BigDecimal.ZERO,
    val items: BigDecimal = BigDecimal.ZERO,
)
