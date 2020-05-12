package com.holiday.planner.freeDaysAPI

import com.google.gson.Gson
import com.holiday.planner.freeDaysAPI.model.FreeDaysResponseData
import com.holiday.planner.freeDaysAPI.model.HolidayDay
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.HttpHeaders.CONTENT_TYPE
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.kotlin.core.publisher.toFlux


//@Component
//class FreeDaysAPI : ItfFreeDaysAPI {
//
//    private val baseUrl = "https://calendarific.com/api/v2/holidays/"
//
//    private val token: String = "c0ddd8d934503ef555bea4a309e4e34138e02d0adf6050e70545e398e7988737"
//
//    private val typeHolliday: String = "national"
//
//    @Cacheable("holidays")
//    override fun getHolidays(country: String, year: Int): Flux<HolidayDay> {
//
//        val webclient = WebClient
//                .builder()
//                .baseUrl(baseUrl)
//                .defaultCookie("cookieKey", "cookieValue")
//                .defaultHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
//                .build()
//
//        return webclient.get().uri {
//            it.queryParam("country", country).queryParam("year", year).queryParam("api_key", token).queryParam("type", typeHolliday).build()
//        }.retrieve().bodyToMono(String::class.java).map { Gson().fromJson(it, FreeDaysResponseData::class.java)
//        }.map { it.body.holidays }.flatMapMany { it.toFlux() }
//    }
//}