package com.company.casual_job_mart.casualJobMart

import android.graphics.Picture
import java.util.*

class Job (val jobID:String, val ownerID:String, var jobName:String="", var location:Location=Location(), var duration:Duration=Duration(), var quotation:Float=0F, var image:Picture=Picture(), var discription:String=String(), var status:String = "Draft"){

    constructor() : this("","","")

    public fun getID():String{
        return this.jobID
    }

    public fun getOwner():String{
        return this.ownerID
    }

}