package com.holiday.planner.freeDaysAPI.model

import com.google.gson.annotations.SerializedName

class HolidayDay {

    @SerializedName("name")
    var name: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("type")
    var type: List<String>? = emptyList()

    @SerializedName("date")
    var date: HolidayDate = HolidayDate()
}
