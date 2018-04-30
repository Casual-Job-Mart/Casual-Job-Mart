package com.company.casual_job_mart.casualJobMart

import android.graphics.Picture
import java.util.*

class Job (ownerID:String){
    private var id:Int = 0
    private var name:String = String()
    private var ownerID:String = ownerID
    private var startTime: Date = Date()
    private var endTIME:Date = Date()
    private var quotation:Float = 0F
    private var picture:Picture = Picture()
    private var discription:String = String()
    private var status:String = String()
    private var isActivity:Boolean = false


    public fun getID():Int{
        return this.id
    }

    public fun setName(jobName:String){
        this.name = jobName
    }

    public fun getName():String{
        return this.name
    }

    public fun setOwnerID(id:String){
        this.ownerID = id
    }

    public fun getOwnerID():String{
        return this.ownerID
    }

    public fun setStartTime(time:Date){
        this.startTime = time
    }





}