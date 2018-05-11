package com.company.casual_job_mart.casualJobMart

import android.graphics.Picture
import java.util.*

class Job (val jobID:String,var ownerID:String,var jobName:String="",var startTime:String=String(),var endTime:String=String(),var quotation:Float=0F,var picure:Picture=Picture(),var discription:String=String()){

    public var status:String = "Draft"

/*
    public fun getID():String{
        return this.jobID
    }

    public fun getName():String{
        return this.name
    }

    public fun getOwnerID():String{
        return this.ownerID
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