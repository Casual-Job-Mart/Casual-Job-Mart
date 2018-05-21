package com.company.casual_job_mart.casualJobMart

class Duration(var startTime:String, var endTime:String) {
    constructor() : this("","")

    /*
    * String format: YYYY-MM-DD HH:MM
    * */

    fun setDuration(startT: String, endT: String){
        startTime = startT
        endTime = endT
    }
}