package com.holiday.planner.freeDaysAPI

import com.google.gson.Gson
import com.holiday.planner.freeDaysAPI.model.FreeDaysResponseData
import com.holiday.planner.freeDaysAPI.model.HolidayDay
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono


@Component
class FreeDaysAPIDummy : ItfFreeDaysAPI {

    override fun getCountries(country: String, year: Int): Mono<List<HolidayDay>> {

        val path = "dummyHolidayData"
        var text: String? = ""

        ClassPathResource(path).file.bufferedReader().readLines().forEach{ text += it }

        val response : FreeDaysResponseData = Gson().fromJson(text, FreeDaysResponseData::class.java)
        return Mono.just(response.body.holidays)
    }
}