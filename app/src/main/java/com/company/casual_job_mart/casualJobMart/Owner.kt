package com.company.casual_job_mart.casualJobMart

class Owner (idNumber:Int){
    private var id:Int = idNumber
    private var jobList:MutableList<Pair<Int,Job>> = ArrayList()

    public fun getID():Int{
        return this.id
    }

    public fun addNewJob(job:Job){
        //jobList.add(Pair(job.getID(),job))
    }

    public fun getJobList():List<Pair<Int,Job>>{
        return jobList
    }
}