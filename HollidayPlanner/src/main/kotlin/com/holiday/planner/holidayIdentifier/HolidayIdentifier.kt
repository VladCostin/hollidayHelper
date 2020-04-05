package com.holiday.planner.holidayIdentifier

import com.holiday.planner.model.DayCandidate
import com.holiday.planner.model.IntervalCandidate
import org.springframework.stereotype.Component
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.ChronoUnit

@Component
class HolidayIdentifier : ItfHolidayIdentifier {
    override fun getWeeksCandidate(days: List<DayCandidate>): List<IntervalCandidate> {

        var intervals : MutableList<IntervalCandidate> = getIntervalCandidates(days);

        fillGaps(intervals);
        intervals =  mergeIntervals(intervals);

        return intervals
    }

    private fun mergeIntervals(intervals : List<IntervalCandidate>) : MutableList<IntervalCandidate> {

        var result : MutableList<IntervalCandidate> = mutableListOf();
        var i = 0;

        while (i <  intervals.size) {

            var interval : IntervalCandidate = intervals[i];

            if(interval.isFilled()) {

                while(  i < intervals.size - 1 && intervals[i+1].isFilled() &&  ChronoUnit.DAYS.between(intervals[i].rightEdge, intervals[i+1].leftEdge) <= 1 ) {

                    interval.addDays(intervals[i+1].days);
                    interval.rightEdge = intervals[i+1].rightEdge;
                    i++;
                }
            }

            i++;
            result.add(interval);
        }

        return result;
    }


    private fun getIntervalCandidates(days : List<DayCandidate>) : MutableList<IntervalCandidate> {

        var result : MutableList<IntervalCandidate> = mutableListOf();

        for (i in days.indices) {

            val before = if (i > 0) days[i-1] else null;
            result.add(getFirstInterval( days[i], before));


            val after = if(i < days.size -1 ) days[i + 1] else null;
            result.add(getSecondInterval(days[i], after));
        }


        return result;
    }

    private fun getFirstInterval(current : DayCandidate, before : DayCandidate?) : IntervalCandidate {


        val dayBeginningWeek = current.getBeginningWeek();
        var result : IntervalCandidate;

        if(before != null && before.isAfter(dayBeginningWeek)) {

            result  = IntervalCandidate(before.dateDayLocalDate, current.dateDayLocalDate);

            result.days.add(before);
            result.days.add(current);

        } else {

            result  = IntervalCandidate( dayBeginningWeek, current.dateDayLocalDate);

            result.days.add(current);
        }

        return result;
    }

    private fun getSecondInterval(current : DayCandidate, next : DayCandidate?) : IntervalCandidate {

        val dayEndWeek = current.getEndOfTheWeek();
        var result : IntervalCandidate;

        if(next != null && next.isBefore(dayEndWeek)) {

            result  = IntervalCandidate(current.dateDayLocalDate, next.dateDayLocalDate);

            result.days.add(current);
            result.days.add(next);

        } else {

            result  = IntervalCandidate(current.dateDayLocalDate, dayEndWeek);

            result.days.add(current);
        }

        return result;
    }

    private fun fillGaps(intervals :  MutableList<IntervalCandidate> ) : MutableList<IntervalCandidate> {


        for(i in 1..2) {

            intervals.forEach{ fillGap(i, it) };
        }

        for(interval in intervals) {

            interval.sortDays();
        }

        return intervals;
    }

    private fun fillGap(nrDay : Int,  interval : IntervalCandidate) : IntervalCandidate {


        val difference : Long = ChronoUnit.DAYS.between(interval.leftEdge, interval.rightEdge) - 1;

        if(difference == nrDay.toLong()) {

            for(i in  1..difference) {

                val date = interval.leftEdge.plusDays( i);

                interval.days.add(DayCandidate(date.toString()));
            }
        }

        return interval;
    }

    private fun DayCandidate.getBeginningWeek() : LocalDate {

        var localDate = dateDayLocalDate;
        var dayOfWeek : DayOfWeek = DayOfWeek.from(localDate);
        var result = localDate.minusDays(dayOfWeek.value.toLong());

        return result;
    }

    private fun DayCandidate.getEndOfTheWeek() : LocalDate {

        var beginningWeek = getBeginningWeek();
        var result =  beginningWeek.plusDays(DayOfWeek.SATURDAY.value.toLong() );

        return result;
    }
}