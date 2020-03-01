package com.holliday.planner.HollidayPlanner

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/holliday")
class HollidayController {

	@GetMapping("/hello")
    fun helloKotlin(): String {
        return "hello world"
    }
}