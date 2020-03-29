package com.holiday.planner.servlet

import com.holiday.planner.freeDaysAPI.model.HolidayDay
import com.holiday.planner.model.DayCandidate
import com.holiday.planner.service.ItfHolidayService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/holiday")
class HolidayController(private val holidayService: ItfHolidayService) {
	
	
	@GetMapping("/hello")
    fun helloKotlin(): Flux<DayCandidate?> {
        return holidayService.getHoliday("de", true,null, null )
    }
}