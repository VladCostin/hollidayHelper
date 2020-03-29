package com.holliday.planner.freeDaysAPI

import com.holliday.planner.freeDaysAPI.model.FreeDaysResponseData
import reactor.core.publisher.Mono


interface ItfFreeDaysAPI {

    fun getCountries(country: String, year: Int): Mono<FreeDaysResponseData>
}