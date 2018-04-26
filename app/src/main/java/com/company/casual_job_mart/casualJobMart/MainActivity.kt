package com.company.casual_job_mart.casualJobMart

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //private var workerList: MutableList<Worker> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //Testing
    /*
    fun createUser(){
        var user1 = User(1)
        user1.setPhone("7808503263")
        Toast.makeText(this,user1.getPhone(),Toast.LENGTH_SHORT).show()
    }
    fun testWorker(){
        var worker1 = Worker(1)
        worker1.increaseRatingCount()
        this.workerList.add(worker1)
    }
    fun testWorker2(){
        var worker1 = this.workerList.get(0)
        Toast.makeText(this,worker1.getRatingCount().toString(),Toast.LENGTH_SHORT).show()
    }
    */
}
