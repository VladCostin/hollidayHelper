package com.holiday.planner.service

import com.holiday.planner.freeDaysAPI.ItfFreeDaysAPI
import com.holiday.planner.freeDaysAPI.model.HolidayDay
import com.holiday.planner.holidayIdentifier.ItfHolidayIdentifier
import com.holiday.planner.model.DayCandidate
import com.holiday.planner.model.IntervalCandidate
import java.time.LocalDate
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import java.time.DayOfWeek

@Component
class HolidayService(private val freeDaysAPI: ItfFreeDaysAPI, private val holidayIdentifier: ItfHolidayIdentifier) : ItfHolidayService {


    override fun getHoliday(x: String, onlyFilled: Boolean, fromDate: LocalDate?, toDate: LocalDate?, onlyFuture: Boolean, gapsSize: List<Int>): Mono<List<IntervalCandidate>> {

        return freeDaysAPI.getHolidays(x, 2020).map { it.mapDay() }.filter { it.filterByInterval(fromDate, toDate, onlyFuture) }.collectList().map { it ->
            holidayIdentifier.getWeeksCandidate(it.toList(), gapsSize).filter { it.filterOnlyFilled(onlyFilled) }
        }
    }

    private fun DayCandidate.filterByInterval(fromDate: LocalDate?, toDate: LocalDate?, onlyFuture: Boolean) = isDayAfter(fromDate) &&
            isDayBefore(toDate) && isDayNotInWeekend() && isNotPassed(onlyFuture)

    private fun DayCandidate.isDayNotInWeekend(): Boolean {

        return dateDayLocalDate.dayOfWeek != DayOfWeek.SATURDAY && dateDayLocalDate.dayOfWeek != DayOfWeek.SUNDAY

    }

    private fun DayCandidate.isDayAfter(fromDate: LocalDate?) = fromDate == null || isAfter(fromDate)

    private fun DayCandidate.isDayBefore(toDate: LocalDate?) = toDate == null || isBefore(toDate)

    private fun DayCandidate.isNotPassed(onlyFuture: Boolean) = !onlyFuture || isAfter(LocalDate.now())

    private fun HolidayDay.mapDay(): DayCandidate {

        val result = DayCandidate(date.date!!)

        result.freeDay = true
        result.freeDayName = name
        result.freeDayReason = description

        return result
    }

    fun IntervalCandidate.filterOnlyFilled(onlyFilled: Boolean) = !onlyFilled ||
            days.stream().anyMatch { !it.freeDay && DayOfWeek.from(it.dateDayLocalDate) != DayOfWeek.SATURDAY && DayOfWeek.from(it.dateDayLocalDate) != DayOfWeek.SUNDAY }

}