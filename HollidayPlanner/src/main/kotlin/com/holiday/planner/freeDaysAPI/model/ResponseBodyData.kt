package com.holiday.planner.freeDaysAPI.model

import com.google.gson.annotations.SerializedName

class ResponseBodyData {

    @SerializedName("holidays")
    var holidays:List<HolidayDay> = emptyList()

}