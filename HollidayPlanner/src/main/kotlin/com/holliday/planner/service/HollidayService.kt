package com.holliday.planner.service

import java.time.LocalDate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HollidayService {
	
	/*

	private val apiFreeDays: FreeDaysAPI;

	private val holidayIdentifier: ItfHollidayIdentifier;

	private val mapper: ItfClassMapper;

	init {

		apiFreeDays = FreeDaysAPI();
		holidayIdentifier = HollidayIdentifier();
		mapper = ClassMapper();

	}
	*/

	fun getHolliday() : String {
		
		return "well, hello there!";
	}
	
//	fun getHolliday(x: String, onlyFilled : Boolean, fromDate : LocalDate?, toDate : LocalDate?): PairResult<List<IntervalCandidate>> {
//
//		var response: ResponseData? = apiFreeDays.getCountries("ro", 2020);
//		var result: PairResult<List<IntervalCandidate>>;
//
//		try {
//			
//			if(response == null) {
//				
//				result = PairResult(500);
//				
//			} else if ( !response.isSuccess()) {
//
//				result = PairResult(response.getErrorCode());
//			} else {
//				
//				var days: List<DayCandidate> = mapper.mapDays(response.getHollidays());
//				days = filterByInterval(days, fromDate, toDate);
//				
//				var weeks: List<IntervalCandidate> = holidayIdentifier.getWeeksCandidate(days);
//				weeks = filterOnlyFilled(weeks, onlyFilled);
//				
//				result = PairResult(200, weeks);
//			}
//			
//		} catch (e: Exception) {
//
//			result = PairResult(500);
//			
//			System.out.println(e.toString());
//		}
//
//		return result;
//	}
//	
//	fun filterByInterval(days : List<DayCandidate>, fromDate : LocalDate?, toDate : LocalDate?) : List<DayCandidate> {
//		
//		if(fromDate == null && toDate == null) {
//			
//			return days;
//		}
//		
//		var result = days;
//		
//		fromDate?.let { result = result.filter { day -> day.isAfter(fromDate) }};
//		toDate?.let { result = result.filter { day -> day.isBefore(toDate) }};
//		
//		return result;
//	}
//	
//	fun filterOnlyFilled(intervals: List<IntervalCandidate>, onlyFilled : Boolean) : List<IntervalCandidate> {
//		
//		if( !onlyFilled) {
//			
//			return intervals;
//		}
//		
//		
//	 	return intervals.filter { interval -> interval.hasFilledDays() };
//		
//	}
}