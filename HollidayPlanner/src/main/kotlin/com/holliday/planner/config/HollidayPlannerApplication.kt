package com.holliday.planner.config

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com.holliday.planner.servlet")
open class HollidayPlannerApplication

fun main(args: Array<String>) {
	runApplication<HollidayPlannerApplication>(*args)
}
