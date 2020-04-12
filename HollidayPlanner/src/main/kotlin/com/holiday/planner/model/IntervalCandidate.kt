package com.holiday.planner.model

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.ChronoUnit

data class IntervalCandidate(var leftEdge : LocalDate, var rightEdge : LocalDate) {

    var days : MutableList<DayCandidate>

    init {

        days = mutableListOf()
    }

    override fun toString() : String {

        return leftEdge.toString() + " (" + DayOfWeek.from(leftEdge) +  ") - " + rightEdge.toString() + " (" + DayOfWeek.from(rightEdge)  +  ")"
    }

    fun sortDays() {

        days = days.sortedWith( compareBy {it.dateDayLocalDate}).toMutableList()
    }


    fun addDays( toAdd: MutableList<DayCandidate>) {

        if(days.isEmpty()) {

            days.addAll(toAdd)
        } else if(toAdd.isNotEmpty()) {

            if(days.get(days.size - 1).isSameDay(toAdd.get(0))) {

                days.addAll( toAdd.subList(1, toAdd.size) )
            } else {

                days.addAll(toAdd)
            }

        }

    }

}