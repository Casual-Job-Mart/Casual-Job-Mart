package com.company.casual_job_mart.casualJobMart

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class JobAdapter(val mCtx:Context, val layoutResId:Int, val jobList:List<Job>) : ArrayAdapter<Job>(mCtx,layoutResId,jobList){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater:LayoutInflater = LayoutInflater.from(mCtx)
        val view:View = layoutInflater.inflate(layoutResId,null)

        val textView = view.findViewById<TextView>(R.id.textViewName)
        val job = jobList[position]
        textView.text = job.jobName
        return view
    }
}