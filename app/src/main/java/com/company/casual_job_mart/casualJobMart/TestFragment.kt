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

        })
        return myView
    }

    fun testPushUser(){
        val userID = DbManager().pushUser()
        val user = User(userID,"7808503263","abc@test.com","Stark","Tony")
        DbManager().updateUser(user).toString()
    }

    fun testPushJob(){
        var jobID = DbManager().pushJob()
        val startTime = "2018-05-01 0800"
        val endTime = "2018-05-01 1630"
        val job = Job(jobID,"test123","Maintenance", Location("1111, Test Ave NW","Vancouver","BC","Canada","x1x1x1"),Duration(),100.00F, discription = "Test job want nice workers!")
        DbManager().updateJob(job)
        var jobID2 = DbManager().pushJob()
        val job2 = Job(jobID2,"test456","sales associate", Location("1000, 1St Street","Calgary","AB","Canada","T6H0B2"),Duration(),80.00F, discription = "Test job 2 want nice workers!")
        DbManager().updateJob(job2)
    }




}
