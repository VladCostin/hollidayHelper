package com.holiday.planner.servlet


import com.holiday.planner.model.HolidayDto
import com.holiday.planner.model.IntervalCandidate
import com.holiday.planner.service.ItfHolidayService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import javax.annotation.PostConstruct

@RestController
@RequestMapping("/holiday")
class HolidayController(private val holidayService: ItfHolidayService) {


    @GetMapping("/request")
    fun get(@RequestParam(name = "country") country: String,
                    @RequestParam(name = "only_filled", defaultValue = "true") onlyFilled: Boolean = true,
                    @RequestParam(name = "only_future", defaultValue = "true") onlyFuture: Boolean = true,
                    @RequestParam(name= "gaps_size") gapsSize: List<Int>): Mono<List<IntervalCandidate>> {
        return holidayService.getHoliday(country, onlyFilled, null, null, onlyFuture, gapsSize)
    }

    @PutMapping
    fun save(  @RequestBody holiday : HolidayDto) {

        holidayService.save(holiday)

    }
}