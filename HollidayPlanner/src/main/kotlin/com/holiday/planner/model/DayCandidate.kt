package com.holiday.planner.model

import java.util.Date
import java.time.LocalDate
import java.time.DayOfWeek

class DayCandidate(dayString : String) {

    var freeDay : Boolean = false

    private val dateDayString : String = dayString

    val dateDayLocalDate : LocalDate = LocalDate.parse(dayString)

    var freeDayName : String? = null

    var freeDayReason : String? = null


    override fun toString() : String {

        return  dateDayString

    }

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