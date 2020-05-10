package com.holiday.planner.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*

data class HolidayDto(val userId: String,
                      @JsonFormat(pattern="yyyy-MM-dd") val from: Date,
                      @JsonFormat(pattern="yyyy-MM-dd") val to: Date) {

    val title: String? = null
}