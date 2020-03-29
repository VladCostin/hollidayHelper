package com.holiday.planner.freeDaysAPI.model

import com.google.gson.annotations.SerializedName

class FreeDaysResponseData {

    @SerializedName("meta")
    var metadata : ResponseMetaData = ResponseMetaData()

    @SerializedName("response")
    var body: ResponseBodyData = ResponseBodyData()


    fun isSuccess() : Boolean {

        return metadata.code != null && metadata.code == 200
    }

    fun getErrorCode() : Int? {

        return metadata.code
    }

    fun getHollidays() : List<HolidayDay> {

        return body.holidays
    }

}