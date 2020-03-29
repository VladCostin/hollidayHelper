package com.holliday.planner.freeDaysAPI

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import com.holliday.planner.freeDaysAPI.model.FreeDaysResponseData
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class FreeDaysAPIDummy : ItfFreeDaysAPI {

    override fun getCountries(country: String, year: Int): Mono<FreeDaysResponseData> {

        val path = "dummyHolidayData.txt"
        var text: String? = ""

        ClassPathResource(path).file.bufferedReader().readLines().forEach{ text += it }

        val response : FreeDaysResponseData = Gson().fromJson(text, FreeDaysResponseData::class.java)
        return Mono.just(response)
    }
}