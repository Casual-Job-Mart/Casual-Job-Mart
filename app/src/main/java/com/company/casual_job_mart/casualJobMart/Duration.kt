package com.company.casual_job_mart.casualJobMart

import android.os.Build
import android.support.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class Duration(var startTime:String, var endTime:String) {
    constructor() : this("","")

    /*
    * String format: YYYY-MM-DD HH:MM
    * */

    fun setDuration(startT: String, endT: String){
        startTime = startT
        endTime = endT
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun getDuration():Int{

        return 0
    }
}