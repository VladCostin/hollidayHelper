package com.holiday.planner.service

import com.holiday.planner.datamapper.ItfClassMapper
import com.holiday.planner.freeDaysAPI.ItfFreeDaysAPI
import com.holiday.planner.freeDaysAPI.model.HolidayDay
import com.holiday.planner.model.DayCandidate
import java.time.LocalDate
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class HolidayService(private val freeDaysAPI: ItfFreeDaysAPI, private val mapper : ItfClassMapper) : ItfHolidayService {
	
	/*


	private val holidayIdentifier: ItfHollidayIdentifier;

	private val mapper: ItfClassMapper;

	init {

		apiFreeDays = FreeDaysAPI();
		holidayIdentifier = HollidayIdentifier();
		mapper = ClassMapper();

	}
	*/

	override fun getHoliday(x: String, onlyFilled : Boolean, fromDate : LocalDate?, toDate : LocalDate?) : Flux<DayCandidate?> {
		
		return freeDaysAPI.getCountries(x, 2020).map { mapper.mapDay(it) }.filter { filterByInterval(it, fromDate, toDate)  }
	}

	private fun filterByInterval(day : DayCandidate?, fromDate : LocalDate?, toDate : LocalDate?) : Boolean {

		if(fromDate == null && toDate == null) {
			return true
		}

		if(day == null) {
			return false
		}

		return day.isAfter(fromDate!!) && day.isBefore(toDate!!)
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