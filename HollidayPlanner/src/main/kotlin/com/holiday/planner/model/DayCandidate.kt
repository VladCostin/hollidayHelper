package com.holiday.planner.model

import java.util.Date
import java.time.LocalDate
import java.time.DayOfWeek

data class DayCandidate(private val dayString : String) {

    var freeDay : Boolean = false

    var workingDay : Boolean = false

    val dateDayLocalDate : LocalDate = LocalDate.parse(dayString)

    val dayOfTheWeek : DayOfWeek = LocalDate.parse(dayString).dayOfWeek

    var freeDayName : String? = null

    var freeDayReason : String? = null

    fun isAfter(date : LocalDate) : Boolean {

        return dateDayLocalDate.isAfter(date)
    }

    fun isBefore(date : LocalDate) : Boolean {

        return dateDayLocalDate.isBefore(date)
    }

    fun isSameDay(date : DayCandidate) : Boolean {

        return dateDayLocalDate.isEqual(date.dateDayLocalDate)
    }

}