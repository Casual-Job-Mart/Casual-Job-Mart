package com.company.casual_job_mart.casualJobMart

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [LogInActivityMainPageFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [LogInActivityMainPageFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class LogInActivityMainPageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_log_in_acticity_main_page, container, false)
    }
}
