package com.holiday.planner.model

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class IntervalCandidate(leftEdge : LocalDate, rightEdge : LocalDate) {

    var days : MutableList<DayCandidate>;

    var leftEdge : LocalDate = leftEdge;

    var rightEdge : LocalDate = rightEdge;

    init {

        days = mutableListOf();
    }

    override fun toString() : String {

        return leftEdge.toString() + " (" + DayOfWeek.from(leftEdge) +  ") - " + rightEdge.toString() + " (" + DayOfWeek.from(rightEdge)  +  ")";
    }

    fun sortDays() {

        days = days.sortedWith( compareBy( {it.dateDayLocalDate})).toMutableList();
    }

    fun hasFilledDays() : Boolean {

        return days.size > 1;

    }

    fun addDays( toAdd: MutableList<DayCandidate>) {

        if(days.isEmpty()) {

            days.addAll(toAdd);
        } else if(!toAdd.isEmpty() ) {

            if(days.get(days.size - 1).isSameDay(toAdd.get(0))) {

                days.addAll( toAdd.subList(1, toAdd.size) );
            } else {

                days.addAll(toAdd);
            }

        }

    }

    fun isFilled() : Boolean {

        var daysBetween = ChronoUnit.DAYS.between(leftEdge, rightEdge);


        return days.size >= daysBetween;
    }
}