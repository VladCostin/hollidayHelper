package com.holiday.planner.config

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com.holiday.planner.servlet", "com.holiday.planner.service", "com.holiday.planner.freeDaysAPI", "com.holiday.planner.datamapper")
class HolidayPlannerApplication

fun main(args: Array<String>) {
	runApplication<HolidayPlannerApplication>(*args)
}
