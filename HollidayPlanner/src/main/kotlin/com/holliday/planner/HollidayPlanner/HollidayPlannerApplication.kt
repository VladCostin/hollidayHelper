package com.holliday.planner.HollidayPlanner

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class HollidayPlannerApplication

fun main(args: Array<String>) {
	runApplication<HollidayPlannerApplication>(*args)
}
