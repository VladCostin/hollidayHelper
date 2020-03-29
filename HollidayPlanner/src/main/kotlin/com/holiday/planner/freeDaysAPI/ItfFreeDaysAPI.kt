package com.holiday.planner.freeDaysAPI

import com.holiday.planner.freeDaysAPI.model.FreeDaysResponseData
import com.holiday.planner.freeDaysAPI.model.HolidayDay
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


interface ItfFreeDaysAPI {

    fun getCountries(country: String, year: Int): Flux<HolidayDay>
}