import java.lang.Exception
import java.util.Scanner

fun main(args: Array<String>) {
    var listOfSports= listOf<String>("Badminton court","Football","cricket ")
    val badminton:MutableMap<String,String> = mutableMapOf()
    val cricket:MutableMap<String,String> = mutableMapOf()
    val football:MutableMap<String,String> = mutableMapOf()
        //badminton slots
    badminton.put("1","10:00Am to 11:00Am")
    badminton.put("2","11:00Am to 12:00pm")
    badminton.put("3","12:00pm to 1:00pm")
    badminton.put("4","1:00pm to 2:00pm")
    badminton.put("5","2:00pm to 3:00pm")
    badminton.put("6","3:00pm to 4:00pm")
    badminton.put("7","4:00pm to 5:00pm")
    badminton.put("8","5:00pm to 6:00pm")
    badminton.put("9","6:00pm to 7:00pm")
    badminton.put("10","7:00pm to 8:00pm")
    //football slots
    football.put("1","10:00Am-10:30Am")
    football.put("2","10:30Am-11:00Am")
    football.put("3","11:00Am-11:30Am")
    football.put("4","11:30Am-12:00pm")
    football.put("5","12:00pm-12:30pm")
    football.put("6","12:30pm-1:00pm")
    football.put("7","1:00pm-1:30pm")
    football.put("8","1:30pm-2:00pm")
    football.put("9","2:00pm-2:30pm")
    football.put("10","2:30pm-3:00pm")
    football.put("11","3:00pm-3:30pm")
    football.put("12","3:30pm-4:00pm")
    football.put("13","4:00pm-4:30pm")
    football.put("14","4:30pm-5:00pm")
    football.put("15","5:00pm_5:30pm")
    football.put("16","5:30pm-6:00pm")
    football.put("17","6:00pm-6:30pm")
    football.put("18","6:30pm-7:00pm")
    football.put("19","7:00pm-7:30pm")
    football.put("20","7:30pm-8:00pm")
    //Cricket slotes
    cricket.put("1","10:00am-12pm")
    cricket.put("2","12:00pm-2:00pm")
    cricket.put("3","2:00pm-4:00pm")
    cricket.put("4","4:00pm-6:00pm")
    cricket.put("5","6:00pm-8:00pm")
    try {
        var read = Scanner(System.`in`)
        println("Please enter your name")
        var name = read.next()
        do {
            for (sports in listOfSports)
                println(sports)
            println("enter 1 for badminton /n enter 2 for football /n emter 3 for cricket")
            var check = read.nextInt()
            when (check) {
                1 -> {
                    println("your choosen badmintom these are the available slots with timings")
                    for (keys in badminton.keys) {
                        println("slot number ${keys}  with timing ${badminton[keys]}")
                    }
                    println("enter 1 for slot1 enter 2 for slot2  enter 3 for slot 3 enter 4 for slot 4 enter 5 for slot5 enter 6 for slot6 enter 7 for slot7 enter 8 for slot8 ,enter 9 for slot9 , enter 10 for slot10")
                    var slot = read.nextInt()
                    when (slot) {
                        1, 2, 3, 4, 5, 6, 7, 8, 9, 10 -> {
                            println("your slot registered successfully")
                            badminton.remove("$slot")
                        }

                        else -> {
                            println("this slot is not available please please select the slot from list")
                        }
                    }


                }

                2 -> {
                    println("your choosen football these are the available slots with timings")
                    for (keys in football.keys) {
                        println("slot number ${keys}  with timing ${football[keys]}")
                    }
                    println("enter 1 for slot1 , enter 2 for slot2, enter 3 for slot 3 ,enter 4 for slot 4 ,enter 5 for slot5 , enter 6 for slot6 ,enter 7 for slot ,enter 8 for slot8 ,enter 9 for slot9 ,enter 10 for slot10")
                    println("enter 11 for slot11 ,enter 12 for slot12 , enter 13 for slot 13, enter 14 for slot 14 ,enter 15 for slot15 , enter 16 for slot16 , enter 17 for slot17 , enter 18 for slot18 , enter 19 for slot19 , enter 20 for slot20")
                    val footballSlot = read.nextInt()
                    when (footballSlot) {
                        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 -> {
                            println("your slot registered successfully")
                            football.remove("$footballSlot")
                        }

                        else -> {
                            println("this slot is not available please please select the slot from list")
                        }
                    }


                }

                3 -> {
                    println("your choosen football these are the available slots with timings")
                    for (keys in football.keys) {
                        println("slot number ${keys}  with timing ${cricket[keys]}")
                    }
                    println("enter 1 for slot1 , enter 2 for slot2, enter 3 for slot 3 ,enter 4 for slot 4 ,enter 5 for slot5 ")
                    val cricketSlot = read.nextInt()
                    when (cricketSlot) {
                        1, 2, 3, 4, 5 -> {
                            println("your slot registered successfully ")
                            football.remove("$cricketSlot")
                        }

                        else -> {
                            println("this slot is not available please please select the slot from list")
                        }
                    }


                }

                else -> {
                    println("please enter sport name from list")
                }
            }
            println("if you want to continue enter 1 else enter 2")
            val ch=read.nextInt()
        } while (ch==1)
        println("thank you for visiting")
    }catch (e:Exception){
        println("please number")
    }




}