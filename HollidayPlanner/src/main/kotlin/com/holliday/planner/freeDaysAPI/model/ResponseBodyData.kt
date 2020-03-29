package com.holliday.planner.freeDaysAPI.model

import com.google.gson.annotations.SerializedName

class ResponseBodyData {

    @SerializedName("holidays")
    var hollidays:List<HolidayDay> = emptyList()

}