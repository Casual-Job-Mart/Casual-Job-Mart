package com.company.casual_job_mart.casualJobMart

class Owner (idNumber:String){
    private var id:String = idNumber
    private var jobList:MutableList<Pair<Int,Job>> = ArrayList()

    public fun getID():String{
        return this.id
    }

    public fun getJobList():List<Pair<Int,Job>>{
        return jobList
    }
}