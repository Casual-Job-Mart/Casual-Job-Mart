package com.company.casual_job_mart.casualJobMart

class User{
    private var id: Int = 0
    private var phone:String = String()
    private var email:String = String()
    private var lastName:String = String()
    private var firstName:String = String()
    private var worker:Worker? = null
    private var owner:Owner? = null

    public fun getID():Int {
        return this.id
    }

    public fun setPhone(phoneNumber:String){
        this.phone = phoneNumber

    }

    public fun getPhone():String? {
        return this.phone
    }

    public fun setEmail(emailAddr:String){
        this.email = emailAddr
    }

    public fun getEmail():String?{
        return this.email
    }

    public fun setLastName(lastName:String){
        this.lastName = lastName
    }

    public fun getLastName():String?{
        return this.lastName
    }

    public fun setFirstName(firstName:String){
        this.firstName = firstName
    }

    public fun getFirstName():String?{
        return this.firstName
    }
}