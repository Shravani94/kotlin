package com.techouts

class SecondaryConstuctorExample(name:String,mailId:String) {
    val emp_name=name;
    val emp_mail=mailId
    fun show(){
        println("name from primary constructor $emp_name")
        println("mail_Id from primary constuctor $emp_mail")
    }
    constructor(name:String,mobile:Long,mailId: String):this(name, mailId) {
        var emp_mobile=mobile
            println("name from secondary constuctor $name")
            println("mailId from secondary constructor $mailId")
            println("mobile from secondary constructor $emp_mobile")

    }
}
fun main(agrs:Array<String>) {
    var obj = SecondaryConstuctorExample("shravani", 9087654321, "sravani@gmail.com")
    obj.show()
}


