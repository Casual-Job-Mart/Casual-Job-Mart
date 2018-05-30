package com.company.casual_job_mart.casualJobMart


import android.os.Bundle
import android.app.Fragment
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
import com.google.firebase.auth.FirebaseAuthUserCollisionException

/**
 * A simple [Fragment] subclass.
 *
 */
class LogInActivityEmailRegisterFragment : Fragment() {

    lateinit var mAuth: FirebaseAuth

    var TAG = "EMAIL_VERIFICATION"
    lateinit var emailAddress:String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val myView = inflater.inflate(R.layout.fragment_log_in_activity_email_register, container, false)

        var bundle:Bundle = arguments
        if (bundle != null){
            emailAddress = bundle.getString("emailAddress")
            var emailEditText:EditText = myView.findViewById(R.id.LogInActivityEmailRegisterFragmentEmailEditText)
            emailEditText.setText(emailAddress)
        }

        mAuth = FirebaseAuth.getInstance()

        var nextButton:Button = myView.findViewById(R.id.LogInActivityEmailRegisterFragmentNextButton)
        nextButton.setOnClickListener({
            var pwordEditText:EditText = myView.findViewById(R.id.LogInActivityEmailRegisterFragmentPasswordEditText)
            var retypePwordEditText:EditText = myView.findViewById(R.id.LogInActivityEmailRegisterFragmentRetypePasswordEditText)

            var pword:String = pwordEditText.toString()
            var retypePword:String = retypePwordEditText.toString()

            if (!pword.equals(retypePword)){
                Toast.makeText(activity, "Password does not match", Toast.LENGTH_LONG)
            }
            else{
                var emailEditText:EditText = myView.findViewById(R.id.LogInActivityEmailRegisterFragmentEmailEditText)
                emailAddress = emailEditText.toString()
                mAuth.createUserWithEmailAndPassword(emailAddress, pword).addOnCompleteListener(activity){
                    task: Task<AuthResult> ->
                    if (task.isSuccessful){
                        Log.d(TAG, "createUserWithEmail:success")

                    }else{
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        if (task.exception is FirebaseAuthUserCollisionException){
                            Toast.makeText(activity, "Email Address already exists", Toast.LENGTH_LONG)
                        }
                        else{
                            Toast.makeText(activity, "Unable to register, please try again", Toast.LENGTH_LONG)
                        }
                    }
                }
            }

        })



        return myView
    }


}
