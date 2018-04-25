package com.company.casual_job_mart.casualJobMart

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        creatUser()
    }
    fun creatUser(){
        var user1 = User(1)
        user1.setPhone("7808503263")
        Toast.makeText(this,user1.getPhone(),Toast.LENGTH_SHORT).show()
    }
}
