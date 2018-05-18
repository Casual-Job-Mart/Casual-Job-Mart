package com.company.casual_job_mart.casualJobMart

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import android.widget.SearchView
import com.google.firebase.database.*

class SearchJobFragment : Fragment() {

    lateinit var myView: View
    lateinit var ref: DatabaseReference
    lateinit var jobList:MutableList<Job>
    lateinit var listView: ListView


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        myView = inflater!!.inflate(R.layout.fragment_search_job,container,false)

        ref = FirebaseDatabase.getInstance().getReference("jobs")
        jobList = mutableListOf()
        listView = myView.findViewById(R.id.listViewJobList)

        loadData()

        return myView
    }

    fun loadData(){
        ref.addValueEventListener(object : ValueEventListener {
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
    }
}
