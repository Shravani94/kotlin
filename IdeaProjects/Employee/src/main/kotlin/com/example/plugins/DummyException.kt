package com.example.plugins

class DummyException(): Throwable(){
    constructor(msg:String) : this() {
        println("transaction roll back")
    }
}

