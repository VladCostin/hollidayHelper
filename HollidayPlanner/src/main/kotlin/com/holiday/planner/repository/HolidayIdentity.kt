package com.holiday.planner.repository

import java.io.Serializable
import java.util.*
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class HolidayIdentity() : Serializable {

    @Column(name = "userid")
    lateinit var userId: String

    @Column(name = "from_date")
    lateinit var from: Date

    @Column(name = "to_date")
    lateinit var to: Date

    constructor(userId: String, from: Date, to: Date) : this() {

        this.userId = userId
        this.from = from
        this.to = to
    }
}