package com.company.casual_job_mart.casualJobMart


import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth

/**
 * A simple [Fragment] subclass.
 *
 */
class LogInActivityPhoneLogInFragment : Fragment() {

    lateinit var mAuth:FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val myView = inflater.inflate(R.layout.fragment_log_in_activity_phone_log_in, container, false)

        mAuth = FirebaseAuth.getInstance()




        return myView
    }


}
