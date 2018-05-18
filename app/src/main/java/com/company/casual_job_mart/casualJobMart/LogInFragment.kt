package com.company.casual_job_mart.casualJobMart

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class LogInFragment : Fragment() {
    lateinit var myView:View
    lateinit var mAuth:FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        myView = inflater!!.inflate(R.layout.fragment_log_in,container,false)
        mAuth = FirebaseAuth.getInstance()
//
//        val buttonSignIn:Button = myView.findViewById(R.id.fragmentLogInSignInButton)
//        buttonSignIn.setOnClickListener()


        return myView
    }
//    private fun Button.setOnClickListener() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        val inputField:EditText = myView.findViewById(R.id.fragmentSignInFieldEditText)
//        val phoneNumber = inputField.text
//
//        PhoneAuthProvider.getInstance().verifyPhoneNumber(
//                phoneNumber,
//                60,
//                TimeUnit.SECONDS,
//                this,
//                mCallbacks
//        );
//    }
//
//    fun mCallbacks = PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
//
//    }

}

