package com.company.casual_job_mart.casualJobMart

class User(val id:String,var phone:String=String(),var email:String=String(),var lastName:String=String(),var firstName:String = String()){

    public var worker:Worker? = Worker(this.id)
    public var owner:Owner? = Owner(this.id)

    /*
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
    */
}