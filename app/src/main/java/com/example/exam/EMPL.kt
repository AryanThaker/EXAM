package com.example.exam

data class EMPL (var empl_name:String, var empl_password:String) {
    var id: Int = 0
    constructor(id:Int, empl_name: String, empl_password: String):this(empl_name,empl_password)
    {
        this.id=id
    }

}