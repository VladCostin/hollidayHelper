package com.holiday.planner.service

import com.holiday.planner.freeDaysAPI.model.HolidayDay
import com.holiday.planner.model.DayCandidate
import com.holiday.planner.model.HolidayDto
import com.holiday.planner.model.IntervalCandidate
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDate

interface ItfHolidayService {

    fun getHoliday(x: String, onlyFilled : Boolean, fromDate : LocalDate?, toDate : LocalDate?, onlyFuture: Boolean, gapsSize: List<Int>) : Mono<List<IntervalCandidate>>

    fun save(holidayDto: HolidayDto)
}
