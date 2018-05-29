package com.company.casual_job_mart.casualJobMart


import android.os.Bundle
import android.app.Fragment
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import java.io.IOException


/**
 * A simple [Fragment] subclass.
 *
 */
class LogInActivityEmailLogInFragment : Fragment() {

    lateinit var mAuth:FirebaseAuth


    var TAG = "EMAIL_VERIFICATION"

    lateinit var emailAddress:String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val myView = inflater.inflate(R.layout.fragment_log_in_activity_email_log_in, container, false)

        mAuth = FirebaseAuth.getInstance()

        var bundle:Bundle = arguments
        if (bundle != null){
            emailAddress = bundle.getString("emailAddress")
            var emailEditText:EditText = myView.findViewById(R.id.LogInActivityEmailLogInFragmentEmailEditText)
            emailEditText.setText(emailAddress)
        }

        var registerButton:Button = myView.findViewById(R.id.LogInActivityEmailLogInFragmentRegisterButton)
        registerButton.setOnClickListener({
            var newBundle = Bundle()
            newBundle.putString("emailAddress", emailAddress)
            var newFragment = LogInActivityEmailRegisterFragment()
            newFragment.arguments = newBundle
            fragmentManager.beginTransaction().replace(R.id.LogInActivityContent, newFragment).commit()
        })

        var nextButton:Button = myView.findViewById(R.id.LogInActivityEmailLogInFragmentNextButton)
        nextButton.setOnClickListener({

            var passwordEditText:EditText = myView.findViewById(R.id.LogInActivityEmailLogInFragmentPasswordEditText)
            var pword:String = passwordEditText.text.toString()

            var emailEditText:EditText = myView.findViewById(R.id.LogInActivityEmailLogInFragmentEmailEditText)
            emailAddress = emailEditText.text.toString()

            if(pword.length == 0){
                Toast.makeText(activity, "Password is Empty", Toast.LENGTH_LONG)
            }
            else{
                mAuth.signInWithEmailAndPassword(emailAddress, pword).addOnCompleteListener(activity){
                    task:Task<AuthResult> ->
                    if(task.isSuccessful){
                        Log.d(TAG, "signInWithEmail:Success")
                        val newIntent = Intent(activity, MainActivity::class.java)
                        startActivity(newIntent)
                    }
                    else{
                        Log.w(TAG, "signInWithEmail:Failure", task.exception)
                        Toast.makeText(activity, "Authentication fail", Toast.LENGTH_LONG)

                    }
                }

            }
        })


        return myView
    }


}

