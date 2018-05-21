package com.company.casual_job_mart.casualJobMart

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.*
import com.google.firebase.database.*

class SearchJobFragment : Fragment() {

    lateinit var myView: View
    lateinit var jobs: DatabaseReference
    lateinit var jobList:MutableList<Job>
    lateinit var listView: ListView

    lateinit var editTextKeyword: EditText
    lateinit var editTextPlace: EditText


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        myView = inflater!!.inflate(R.layout.fragment_search_job,container,false)
        jobList = mutableListOf()
        listView = myView.findViewById(R.id.listViewJobList)

        editTextKeyword = myView.findViewById(R.id.editTextKeywords)

        jobs = FirebaseDatabase.getInstance().getReference("jobs")

        loadData()

        editTextKeyword.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val keyWord = editTextKeyword.text.toString()

                jobs.orderByChild("jobName").startAt(keyWord).endAt(keyWord+"\uf8ff").addValueEventListener(object:ValueEventListener{
                    override fun onCancelled(p0: DatabaseError?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onDataChange(p0: DataSnapshot?) {
                        if(p0!!.exists()){
                            jobList.clear()
                            for(j in p0.children){
                                val job = j.getValue(Job::class.java)
                                jobList.add(job!!)
                            }
                            val adapter = JobAdapter(activity,R.layout.jobs,jobList)
                            listView.adapter = adapter
                        }
                    }

                })
            }
        })

        editTextKeyword.setOnEditorActionListener { _, p1, _ ->
            var handled = false
            if(p1==EditorInfo.IME_ACTION_SEARCH){
                hideKeyboard()
                handled = true
            }
            handled
        }

        //val keyWord = editTextKeyword.text.toString()
        //val place = editTextPlace.text.toString()




        return myView
    }

    private fun loadData(){
        jobs.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot?) {
                if(p0!!.exists()){
                    jobList.clear()
                    for(j in p0.children){
                        val job = j.getValue(Job::class.java)
                        jobList.add(job!!)
                    }
                    val adapter = JobAdapter(activity,R.layout.jobs,jobList)
                    listView.adapter = adapter
                }
            }

        });
    }

    fun Fragment.hideKeyboard() {
        activity.hideKeyboard(view)
    }
/*
    fun Activity.hideKeyboard() {
        hideKeyboard(if (currentFocus == null) View(this) else currentFocus)
    }
*/
    @SuppressLint("ServiceCast")
    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
