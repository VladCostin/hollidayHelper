package com.holliday.planner.servlet

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping;
import com.holliday.planner.service.HollidayService
import org.springframework.beans.factory.annotation.Autowired

@RestController
@RequestMapping("/holliday")
class HollidayController {

	val service : HollidayService;
	
	init {
		
		service = HollidayService();
	}
	
	
	@GetMapping("/hello")
    fun helloKotlin(): String {
        return "hello world";
    }
}