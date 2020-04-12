package com.holiday.planner.servlet

import com.holiday.planner.freeDaysAPI.model.HolidayDay
import com.holiday.planner.model.DayCandidate
import com.holiday.planner.model.IntervalCandidate
import com.holiday.planner.service.ItfHolidayService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/holiday")
class HolidayController(private val holidayService: ItfHolidayService) {


    @GetMapping("/request")
    fun helloKotlin(@RequestParam(name = "country") country: String, @RequestParam(name = "only_filled", defaultValue = "true") onlyFilled: Boolean = true, @RequestParam(name = "only_future", defaultValue = "true") onlyFuture: Boolean = true): Mono<List<IntervalCandidate>> {
        return holidayService.getHoliday(country, onlyFilled, null, null, onlyFuture)
    }
}