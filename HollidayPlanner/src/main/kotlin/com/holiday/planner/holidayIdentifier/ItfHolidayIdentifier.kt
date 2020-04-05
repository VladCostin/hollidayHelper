package com.holiday.planner.holidayIdentifier

import com.holiday.planner.model.DayCandidate
import com.holiday.planner.model.IntervalCandidate

interface ItfHolidayIdentifier {

    fun getWeeksCandidate(days: List<DayCandidate>): List<IntervalCandidate>
}