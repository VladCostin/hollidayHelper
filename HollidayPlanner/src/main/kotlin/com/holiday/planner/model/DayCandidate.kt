package com.holiday.planner.model

import java.util.Date
import java.time.LocalDate
import java.time.DayOfWeek

class DayCandidate(dayString : String) {

    var freeDay : Boolean = false;

    private val dateDayString : String = dayString;

    val dateDayLocalDate : LocalDate = LocalDate.parse(dayString);

    var selected : Boolean = false;

    var freeDayName : String? = null;

    var freeDayReason : String? = null;

    private fun getBeginningWeek() : LocalDate {

        var localDate = dateDayLocalDate;
        var dayOfWeek : DayOfWeek = DayOfWeek.from(localDate);
        var result = localDate.minusDays(dayOfWeek.getValue().toLong());

        return result;
    }

    fun getEndOfTheWeek() : LocalDate {

        var beginningWeek = getBeginningWeek();
        var result =  beginningWeek.plusDays(DayOfWeek.SATURDAY.getValue().toLong() );

        return result;
    }

    override fun toString() : String {

        return  dateDayString;

    }

    fun isAfter(date : LocalDate) : Boolean {

        return dateDayLocalDate.isAfter(date);
    }

    fun isBefore(date : LocalDate) : Boolean {

        return dateDayLocalDate.isBefore(date);
    }

    fun isSameDay(date : DayCandidate) : Boolean {

        return dateDayLocalDate.isEqual(date.dateDayLocalDate);
    }

}