package com.holiday.planner.datamapper

import com.holiday.planner.freeDaysAPI.model.HolidayDay
import com.holiday.planner.model.DayCandidate

interface ItfClassMapper {

    fun mapDay(day : HolidayDay) : DayCandidate?;

    fun mapDays(days : List<HolidayDay>) : List<DayCandidate>;
}