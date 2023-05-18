package com.techouts

class InterOper {
    fun sum() {
        var sum = InterOperabilityExample().sum(5, 10)
        println("interoperability done")
    }
}
fun main(agrs:Array<String>){
    var obj=InterOper();
    obj.sum()
}