package com.holiday.planner.service

import com.holiday.planner.freeDaysAPI.model.HolidayDay
import reactor.core.publisher.Mono
import java.time.LocalDate

interface ItfHolidayService {

    fun getHoliday(x: String, onlyFilled : Boolean, fromDate : LocalDate?, toDate : LocalDate?) : Mono<List<HolidayDay>>
}
