package com.holliday.planner.config

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com.holliday.planner.servlet", "com.holliday.planner.service", "com.holliday.planner.freeDaysAPI")
class HollidayPlannerApplication

fun main(args: Array<String>) {
	runApplication<HollidayPlannerApplication>(*args)
}
