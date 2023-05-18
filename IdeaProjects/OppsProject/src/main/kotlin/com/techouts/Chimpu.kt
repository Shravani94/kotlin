package com.techouts

import com.sun.deploy.config.Config

open class Chimpu :Money(){
    override fun generation(){
        super.generation()
        println("chimpu overRides Monkyes")
    }
}