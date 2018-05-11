package com.company.casual_job_mart.casualJobMart

import android.graphics.Picture
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    //private var workerList: MutableList<Worker> = ArrayList()
    lateinit var buttonTest:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonTest = findViewById(R.id.testButton)
        buttonTest.setOnClickListener{
            loadDatabase()
        }
    }

    //Testing

    private fun loadDatabase(){
        val ref = FirebaseDatabase.getInstance().getReference("jobs")
        val jobID = ref.push().key
        val startTime = "2018-05-01 0800"
        val endTime = "2018-05-01 1630"
        val job = Job(jobID,"test123","ABC Sample Job",startTime,endTime,100.00F, discription = "Test job want nice workers!")
        print(jobID)
        ref.child(jobID).setValue(job)
        ref.child(jobID).child("status").setValue("Active")
    }



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
