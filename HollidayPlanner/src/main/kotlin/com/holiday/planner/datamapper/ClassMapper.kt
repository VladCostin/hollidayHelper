package com.holiday.planner.datamapper

import com.holiday.planner.freeDaysAPI.model.HolidayDay
import com.holiday.planner.model.DayCandidate
import org.springframework.stereotype.Component
import java.text.SimpleDateFormat

@Component
class ClassMapper : ItfClassMapper {

    private val dateFormat: String;

    private val formater: SimpleDateFormat;

    init {

        dateFormat = "yyyy-MM-dd";
        formater = SimpleDateFormat(dateFormat);
    }

    override
    fun mapDay(day : HolidayDay) : DayCandidate {

        var result = DayCandidate(day.date.date!!);

        result.freeDay = true;
        result.selected = false;
        result.freeDayName = day.name;
        result.freeDayReason = day.description;

        return result;
    }

    override
    fun mapDays(days : List<HolidayDay>) : List<DayCandidate> {

        return days.map{ day -> mapDay(day)}.toList();
    }
}