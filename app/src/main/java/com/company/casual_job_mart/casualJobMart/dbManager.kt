package com.company.casual_job_mart.casualJobMart

import com.google.firebase.database.FirebaseDatabase

class dbManager {
    val jobs = FirebaseDatabase.getInstance().getReference("jobs")
    val owners = FirebaseDatabase.getInstance().getReference("owners")
    fun pushJob():String{
        val jobID = jobs.push().key
        return jobID
    }

    public fun updateJob(job:Job):Boolean{
        var status = false
        jobs.child(job.jobID).setValue(job).addOnCompleteListener{
            status = true
        }
        return status
    }


}