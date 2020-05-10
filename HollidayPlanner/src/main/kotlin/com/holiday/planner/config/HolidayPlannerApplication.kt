package com.holiday.planner.config

import com.holiday.planner.repository.HolidayRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@ComponentScan("com.holiday.planner.servlet", "com.holiday.planner.service",
        "com.holiday.planner.freeDaysAPI", "com.holiday.planner.holidayIdentifier")
@EnableJpaRepositories("com.holiday.planner.repository")
@EntityScan("com.holiday.planner.repository")
class HolidayPlannerApplication

fun main(args: Array<String>) {
    runApplication<HolidayPlannerApplication>(*args)
}
