package com.company.casual_job_mart.casualJobMart

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class JobSavedFragment : Fragment() {
    lateinit var myView:View

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        myView = inflater!!.inflate(R.layout.fragment_job_saved,container,false)
        return myView
    }
}