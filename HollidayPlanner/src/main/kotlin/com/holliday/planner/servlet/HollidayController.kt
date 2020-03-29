package com.holliday.planner.servlet

import com.holliday.planner.freeDaysAPI.model.HolidayDay
import com.holliday.planner.service.ItfHolidayService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/holliday")
class HolidayController(private val holidayService: ItfHolidayService) {
	
	
	@GetMapping("/hello")
    fun helloKotlin(): Mono<List<HolidayDay>> {
        return holidayService.getHoliday("de", true,null, null )
    }
}