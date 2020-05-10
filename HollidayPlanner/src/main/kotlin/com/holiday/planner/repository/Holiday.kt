package com.holiday.planner.repository

import javax.persistence.EmbeddedId
import javax.persistence.Entity


@Entity(name = "holiday")
class Holiday() {

    @EmbeddedId
    lateinit var holidayIdentity: HolidayIdentity

    var title: String? = null

    constructor(holidayIdentity : HolidayIdentity, title: String?) : this() {

        this.holidayIdentity = holidayIdentity
        this.title = title
    }
}