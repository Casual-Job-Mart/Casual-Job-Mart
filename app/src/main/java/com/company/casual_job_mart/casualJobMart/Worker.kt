package com.company.casual_job_mart.casualJobMart

import java.util.*

class Worker (idNumber:Int){

    private var id:Int = idNumber
    private var rating:Float = 0F
    private var ratingCount:Int = 0
    private var reviewList:MutableList<Pair<Date,String>> = ArrayList()
    private var jobHistory:MutableList<Job> = ArrayList()
    private var savedJobs:MutableList<Pair<Int,Job>> = ArrayList()

    public fun getID():Int{
        return this.id
    }

    public fun calculateRating(newRating:Float){
        this.rating = ((rating * ratingCount) + newRating)/ (ratingCount +1)
        increaseRatingCount()
    }

    public fun increaseRatingCount(){
        this.ratingCount = this.ratingCount.plus(1)
    }

    public fun getRatingCount():Int{
        return this.ratingCount
    }

    public fun addReview(newReview:Pair<Date,String>){
        this.reviewList.add(newReview)
    }

    public fun getReviewList():List<Pair<Date,String>>{
        return this.reviewList
    }

    public fun addJobHistory(job:Job){
        this.jobHistory.add(job)
    }

    public fun getJobHistory():List<Job>{
        return jobHistory
    }

    public fun addSavedJobs(job:Job){
        this.savedJobs.add(Pair(job.getID(),job))
    }

    public fun removeSavedJob(jobID:Int){
        for(pair in this.savedJobs){
            if(pair.first == jobID) this.savedJobs.remove(pair)
        }
    }

    public fun getSavedJobs():List<Pair<Int,Job>>{
        return savedJobs
    }

}