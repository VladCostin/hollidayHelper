package com.holiday.planner.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HolidayRepository  : JpaRepository<Holiday, HolidayIdentity>{
}