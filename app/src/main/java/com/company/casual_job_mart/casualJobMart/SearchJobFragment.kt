package com.company.casual_job_mart.casualJobMart

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView

class SearchJobFragment : Fragment() {

    lateinit var myView: View
    lateinit var searchView:SearchView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        myView = inflater!!.inflate(R.layout.fragment_search_job,container,false)
        searchView = myView.findViewById(R.id.searchViewSearchJob)

        return myView
    }
}
