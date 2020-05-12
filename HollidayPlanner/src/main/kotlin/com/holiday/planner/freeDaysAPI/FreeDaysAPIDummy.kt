package com.holiday.planner.freeDaysAPI

import com.google.gson.Gson
import com.holiday.planner.freeDaysAPI.model.FreeDaysResponseData
import com.holiday.planner.freeDaysAPI.model.HolidayDay
import org.apache.commons.io.IOUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux
import java.io.InputStream
import java.nio.charset.StandardCharsets


@Component
class FreeDaysAPIDummy : ItfFreeDaysAPI {

    @Autowired
    lateinit var resourceLoade : ResourceLoader

    @Cacheable()
    override fun getHolidays(country: String, year: Int): Flux<HolidayDay> {

        val inputStream : InputStream = resourceLoade.getResource("classpath:dummyHolidayData").inputStream

        val text = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name())
        val response : FreeDaysResponseData = Gson().fromJson(text, FreeDaysResponseData::class.java)
        return Flux.fromIterable(response.body.holidays)

//        val path = "dummyHolidayData"
//        var text: String? = ""
//
//        ClassPathResource(path).file.bufferedReader().readLines().forEach{ text += it }
//
//        val response : FreeDaysResponseData = Gson().fromJson(text, FreeDaysResponseData::class.java)
//        return Flux.fromIterable(response.body.holidays)
    }
}