package com.company.casual_job_mart.casualJobMart

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import com.google.firebase.database.*

class TestFragment : Fragment() {

    lateinit var myView: View
    lateinit var buttonTest: Button
    lateinit var ref:DatabaseReference
    lateinit var jobList:MutableList<Job>
    lateinit var listView:ListView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        myView = inflater!!.inflate(R.layout.fragment_test,container,false)
        ref = FirebaseDatabase.getInstance().getReference("jobs")
        jobList = mutableListOf()

        buttonTest = myView.findViewById(R.id.buttonTestDB)//view.findViewById(R.id.buttonTestDB)
        buttonTest.setOnClickListener{
            testPushJob()
        }

        listView = myView.findViewById(R.id.listViewTestDB)
        ref.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot?) {
                if(p0!!.exists()){
                    jobList.clear()
                    for(j in p0.children){
                        val job = j.getValue(Job::class.java)
                        jobList.add(job!!)
                    }
                    val adapter = JobAdapter(activity,R.layout.jobs,jobList)
                    listView.adapter = adapter
                }
            }

        });
        return myView
    }

    fun testPushUser(){
        val userID = dbManager().pushUser()
        val user = User(userID,"7808503263","abc@test.com","Stark","Tony")
        dbManager().updateUser(user).toString()
    }

    fun testPushJob(){
        val jobID = dbManager().pushJob()
        val startTime = "2018-05-01 0800"
        val endTime = "2018-05-01 1630"
        val job = Job(jobID,"test123","ABC Sample Job",startTime,endTime,100.00F, discription = "Test job want nice workers!")
        dbManager().updateJob(job)
    }




}
