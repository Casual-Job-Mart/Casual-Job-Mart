package com.company.casual_job_mart.casualJobMart

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

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
        val myView = inflater!!.inflate(R.layout.fragment_log_in_acticity_main_page,container,false)

        val nextButton:Button = myView.findViewById(R.id.LogInActivityMainPageFragmentNextButton)

        nextButton.setOnClickListener ({

            val userInputEditText:EditText = myView.findViewById(R.id.LogInActiviFragmentVertificationCodeEditText)
            val userInput = userInputEditText.text

            if(android.util.Patterns.PHONE.matcher(userInput).matches() && userInput.length > 6 && userInput.length < 13){
                // Go to Phone Log In
                fragmentManager.beginTransaction().replace(R.id.LogInActivityContent, LogInActivityPhoneLogInFragment()).commit()
            }
            else if (android.util.Patterns.EMAIL_ADDRESS.matcher(userInput).matches()){
                // Go to Email Log In
                fragmentManager.beginTransaction().replace(R.id.LogInActivityContent, LogInActivityEmailLogInFragment()).commit()
            }
            else{
                Toast.makeText(activity, "You did not enter a valid phone number of email address", Toast.LENGTH_LONG).show()
            }
        })

        return myView
    }
}
