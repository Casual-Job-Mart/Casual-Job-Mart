package com.company.casual_job_mart.casualJobMart


import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    private val mAuth = FirebaseAuth.getInstance();

    lateinit var navigationView:NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        /*
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }*/

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView = findViewById(R.id.nav_view)
        //navigationView

        nav_view.setNavigationItemSelectedListener(this)
        fragmentManager.beginTransaction().replace(R.id.content_frame,TestFragment()).commit()

        if(mAuth.currentUser == null){
//            var usernameTextView:TextView
//            usernameTextView = findViewById(R.id.navHeaderMainUsernameTextView)
//            usernameTextView.text = "You hadn't login yet"
        }

        val signInButton:Button = findViewById(R.id.mainActivitySignInButton)
        signInButton.setOnClickListener({
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        })
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_search_job -> {
                fragmentManager.beginTransaction().replace(R.id.content_frame,SearchJobFragment()).commit()
            }
            R.id.nav_login -> {
                fragmentManager.beginTransaction().replace(R.id.content_frame, LogInFragment()).commit()
            }
            R.id.nav_message -> {
                fragmentManager.beginTransaction().replace(R.id.content_frame,MessageFragment()).commit()
            }
            R.id.nav_test -> {
                fragmentManager.beginTransaction().replace(R.id.content_frame,TestFragment()).commit()
            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
/*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    //private var workerList: MutableList<Worker> = ArrayList()
    lateinit var buttonTest:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        buttonTest = findViewById(R.id.testButton)
        buttonTest.setOnClickListener{
            loadDatabase()
        }*/
    }

    //Testing

    private fun loadDatabase(){
        val jobID = dbManager().pushJob()

        val startTime = "2018-05-01 0800"
        val endTime = "2018-05-01 1630"

        val job = Job(jobID,"test123","ABC Sample Job",startTime,endTime,100.00F, discription = "Test job want nice workers!")

        val status = dbManager().updateJob(job)
    }

    public fun onNavigationItemSelected(MenuItem item)



    /*
    fun createUser(){
        var user1 = User(1)
        user1.setPhone("7808503263")
        Toast.makeText(this,user1.getPhone(),Toast.LENGTH_SHORT).show()
    }
    fun testWorker(){
        var worker1 = Worker(1)
        worker1.increaseRatingCount()
        this.workerList.add(worker1)
    }
    fun testWorker2(){
        var worker1 = this.workerList.get(0)
        Toast.makeText(this,worker1.getRatingCount().toString(),Toast.LENGTH_SHORT).show()
    }
    */
}*/
