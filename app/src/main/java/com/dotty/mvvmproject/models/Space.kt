package com.dotty.mvvmproject.models

class Space {
    var time_in:String=""
    var time_out:String=""
    var date:String=""
    var space:String=""
    var amount:String=""
    var id:String=""


    constructor(time_in:String, time_out:String, date:String, space:String, amount:String, id:String )
    {
        this.time_in=time_in
        this.time_out=time_out
        this.date=date
        this.space=space
        this.amount=amount
        this.id=id
    }
    constructor()
}