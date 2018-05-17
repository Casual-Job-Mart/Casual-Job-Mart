package com.company.casual_job_mart.casualJobMart

import android.graphics.Picture
import java.util.*

class Job (val jobID:String, val ownerID:String, var jobName:String="", var startTime:String=String(), var endTime:String=String(), var quotation:Float=0F, var image:Picture=Picture(), var discription:String=String(), var status:String = "Draft"){

    constructor() : this("","","")

    public fun getID():String{
        return this.jobID
    }

    public fun getOwner():String{
        return this.ownerID
    }
/*
    public fun getName():String{
        return this.name
    }


    public fun setName(jobName:String){
        this.name = jobName
    }

    public fun setOwnerID(id:String){
        this.ownerID = id
    }

    public fun setDuration(starting:Date,ending:Date){
        this.startTime = starting
        this.endTime = ending
    }

    public fun setQuotation(quote:Float){
        this.quotation = quote
    }

*/



}