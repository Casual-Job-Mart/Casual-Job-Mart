package com.company.casual_job_mart.casualJobMart

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.text.Editable
import android.text.Layout
import android.text.TextWatcher
import android.view.*
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.*
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_search_job.*

class SearchJobFragment : Fragment() {

    lateinit var myView:View
    lateinit var jobs:DatabaseReference
    lateinit var jobList:MutableList<Job>
    lateinit var listView:ListView

    lateinit var imageViewFilter:ImageView
    lateinit var editTextKeyword:EditText
    lateinit var popupWindow:PopupWindow
    lateinit var relativeLayout:RelativeLayout



    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        myView = inflater!!.inflate(R.layout.fragment_search_job,container,false)
        jobList = mutableListOf()
        listView = myView.findViewById(R.id.listViewJobList)

        relativeLayout = myView.findViewById(R.id.fragment_search_job)
        editTextKeyword = myView.findViewById(R.id.editTextKeywords)
        imageViewFilter = myView.findViewById(R.id.imageViewFilter)


        jobs = FirebaseDatabase.getInstance().getReference("jobs")

        loadData()

        editTextKeyword.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val keyWord = editTextKeyword.text.toString()

                jobs.orderByChild("jobName").startAt(keyWord).endAt(keyWord+"\uf8ff").addValueEventListener(object:ValueEventListener{
                    @RequiresApi(Build.VERSION_CODES.M)
                    override fun onCancelled(p0: DatabaseError?) {}

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


        imageViewFilter.setOnClickListener {
            val customView = inflater.inflate(R.layout.poplayout,null)
            popupWindow = PopupWindow(customView,RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT)
            val buttonSave = customView.findViewById<Button>(R.id.buttonOK)
            buttonSave.setOnClickListener { popupWindow.dismiss() }

            popupWindow.showAtLocation(relativeLayout,Gravity.CENTER,0,0)
        }

        return myView
    }

    private fun loadData(){
        jobs.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {}

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

    private fun Fragment.hideKeyboard() {
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
