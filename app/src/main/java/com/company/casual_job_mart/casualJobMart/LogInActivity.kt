package com.company.casual_job_mart.casualJobMart

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)


        fragmentManager.beginTransaction().replace(R.id.LogInActivityContent, LogInActivityMainPageFragment()).commit()

    }
}
