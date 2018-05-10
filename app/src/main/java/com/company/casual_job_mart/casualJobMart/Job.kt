package com.company.casual_job_mart.casualJobMart

import android.graphics.Picture
import java.util.*

class Job (ownerID:String,jobName:String="",startOn:Date=Date(),endOn:Date=Date(),quote:Float=0F,pic:Picture=Picture(),discpt:String=String()){
    private var id:Int = -1
    private var name:String = jobName
    private var ownerID:String = ownerID
    private var startTime: Date = startOn
    private var endTime:Date = endOn
    private var quotation:Float = quote
    private var picture:Picture = pic
    private var discription:String = discpt
    private var status:String = "Draft"
    private var isActivity:Boolean = false

    init{
        loadDatabase()
    }

    /*
    public fun getID():Int{
        return this.id
    }

    public fun getName():String{
        return this.name
    }

    public fun getOwnerID():String{
        return this.ownerID
    }*/

    /*
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
    }*/



    public fun loadDatabase(){

    }




}