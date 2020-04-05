package com.holiday.planner.service

import com.holiday.planner.freeDaysAPI.ItfFreeDaysAPI
import com.holiday.planner.freeDaysAPI.model.HolidayDay
import com.holiday.planner.holidayIdentifier.ItfHolidayIdentifier
import com.holiday.planner.model.DayCandidate
import com.holiday.planner.model.IntervalCandidate
import java.time.LocalDate
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import java.time.DayOfWeek

@Component
class HolidayService(private val freeDaysAPI: ItfFreeDaysAPI, private val holidayIdentifier: ItfHolidayIdentifier) : ItfHolidayService {


    override fun getHoliday(x: String, onlyFilled: Boolean, fromDate: LocalDate?, toDate: LocalDate?, onlyFuture: Boolean): Mono<List<IntervalCandidate>> {

        return freeDaysAPI.getCountries(x, 2020).map { it.mapDay() }.filter { it.filterByInterval(fromDate, toDate, onlyFuture) }.collectList().map {

            holidayIdentifier.getWeeksCandidate(it.toList())
        }
    }

    private fun DayCandidate.filterByInterval(fromDate: LocalDate?, toDate: LocalDate?, onlyFuture: Boolean) = isDayAfter(fromDate) &&
            isDayBefore(toDate) && isDayNotInWeekend() && isNotPassed(onlyFuture)

    private fun DayCandidate.isDayNotInWeekend(): Boolean {

        return dateDayLocalDate.dayOfWeek != DayOfWeek.SATURDAY && dateDayLocalDate.dayOfWeek != DayOfWeek.SUNDAY;

    }

    private inline fun DayCandidate.isDayAfter(fromDate: LocalDate?) = fromDate == null || isAfter(fromDate)

    private inline fun DayCandidate.isDayBefore(toDate: LocalDate?) = toDate == null || isBefore(toDate)

    private inline fun DayCandidate.isNotPassed(onlyFuture: Boolean) = !onlyFuture || isAfter(LocalDate.now())

    private fun HolidayDay.mapDay(): DayCandidate {

        var result = DayCandidate(date.date!!);

        result.freeDay = true;
       // result.selected = false;
        result.freeDayName = name;
        result.freeDayReason = description;

        return result;
    }
}