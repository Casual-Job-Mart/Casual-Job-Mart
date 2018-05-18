package com.company.casual_job_mart.casualJobMart

import com.google.firebase.database.FirebaseDatabase

class DbManager {
    val jobs = FirebaseDatabase.getInstance().getReference("jobs")
    val users = FirebaseDatabase.getInstance().getReference("users")

    fun pushJob():String{
        return jobs.push().key
    }

    fun updateJob(job:Job):Boolean{
        var status = false
        jobs.child(job.jobID).setValue(job).addOnCompleteListener{
            status = true
        }
        return status
    }

    fun pushUser():String{
        return users.push().key
    }

    fun updateUser(user:User):Boolean{
        var status = false
        users.child(user.id).setValue(user).addOnCompleteListener{
            status = true
        }
        return status
    }


}