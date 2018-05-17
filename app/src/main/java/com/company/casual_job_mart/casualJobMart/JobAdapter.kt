package com.company.casual_job_mart.casualJobMart

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class JobAdapter(val mCtx:Context, val layoutResId:Int, val jobList:List<Job>) : ArrayAdapter<Job>(mCtx,layoutResId,jobList){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater:LayoutInflater = LayoutInflater.from(mCtx)
        val view:View = layoutInflater.inflate(layoutResId,null)

        val textView = view.findViewById<TextView>(R.id.textViewJobDetail)
        val imageView = view.findViewById<ImageView>(R.id.imageViewJob)
        val job = jobList[position]
        textView.text = job.jobName + "\n" + job.image.width + " " + job.image.height
        if(Pair(job.image.height,job.image.height) != Pair(0,0)){
            //imageView.
        }
        return view
    }
}