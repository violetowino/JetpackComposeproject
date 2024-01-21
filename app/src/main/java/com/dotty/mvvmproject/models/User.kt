package com.dotty.mvvmproject.models

class User {
    var username:String=""
    var email:String=""
    var password:String=""
    var confirmpassword:String=""
    var userid:String=""

    constructor(username:String, email:String, password:String, confirmpassword:String,userid:String){
        this.username=username
        this.email=email
        this.password=password
        this.confirmpassword=confirmpassword
        this.userid=userid
    }
    constructor()
}