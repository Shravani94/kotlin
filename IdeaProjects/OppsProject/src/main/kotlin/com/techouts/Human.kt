package com.techouts

  class Human:Chimpu() {
      override fun generation() {
          super.generation()
          println("humans override chimpanzee")
      }

    }
fun main(args:Array<String>){
    println("execution start")
    Human().generation()
    println("execution ends")
}
