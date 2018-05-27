package com.company.casual_job_mart.casualJobMart


import android.os.Bundle
import android.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import java.util.concurrent.TimeUnit

/**
 * A simple [Fragment] subclass.
 *
 */
class LogInActivityPhoneLogInFragment : Fragment() {

    lateinit var mAuth:FirebaseAuth
    lateinit var mCallbacks:PhoneAuthProvider.OnVerificationStateChangedCallbacks

    var mVertification: String? = null
    var mResendToken:PhoneAuthProvider.ForceResendingToken? = null

    var TAG = "VERIFICATIONS"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        mAuth = FirebaseAuth.getInstance()

        mCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
            override fun onVerificationCompleted(credential: PhoneAuthCredential?) {
                    Log.d(TAG, "onVertificationCompleted"+credential)
                    signInWithPhoneAuthCredential(credential)
            }

            override fun onVerificationFailed(e: FirebaseException?) {
                Log.w(TAG,"onVertificationFailed", e)

                if(e is FirebaseAuthInvalidCredentialsException){
                    //Invalid request
                }
                else if(e is FirebaseTooManyRequestsException){
                    //SMS Quota for the project has been exceed
                }
                //Show message and update
            }

            override fun onCodeSent(vertificationID: String?, token: PhoneAuthProvider.ForceResendingToken?) {
//                super.onCodeSent(p0, p1)
                mVertification = vertificationID
                mResendToken = token
            }
        }

        // Inflate the layout for this fragment
        var bundle:Bundle = arguments

        var phoneNumber = "999"
        if(bundle != null){
            phoneNumber = bundle.getString("phoneNumber")
            beginVertification(phoneNumber)
        }

        val myView = inflater.inflate(R.layout.fragment_log_in_activity_phone_log_in, container, false)

        val resendButton: Button = myView.findViewById(R.id.LogInActivityPhoneLogInFragmentResendCodeButton)
        resendButton.setOnClickListener({
            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                    phoneNumber,
                    60,
                    TimeUnit.SECONDS,
                    activity,
                    mCallbacks)
        })



        val vertificationCodeEditText:TextView = myView.findViewById(R.id.LogInActivityPhoneLogInFragmentVertificationCodeEditText)
        vertificationCodeEditText.text = phoneNumber

        return myView
    }

    fun beginVertification(phoneNumber:String){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,
                60,
                TimeUnit.SECONDS,
                activity,
                mCallbacks
        )
    }

    fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential?){

        if (credential != null) {
            mAuth.signInWithCredential(credential).addOnCompleteListener(activity){
                task: Task<AuthResult> ->
                if (task.isSuccessful){
                    Log.d(TAG, "signInWithCredential:success")
                }
                else{
                    Log.w(TAG, "signInCredential:failure", task.exception)
                    if(task.exception is FirebaseAuthInvalidCredentialsException){
                        // The vertification code entered was invalide
                        Toast.makeText(activity, "Vertification code entered was invalid", Toast.LENGTH_LONG)
                    }
                }
            }
        }
    }
}
