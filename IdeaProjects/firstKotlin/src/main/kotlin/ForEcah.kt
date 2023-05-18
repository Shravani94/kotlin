fun main(){
    var name= arrayOf("shravani","ruksana","maniratnam","babu","amulya","pavan")
    println("for loop traditional way")
    for(values in name){
        println(values)
    }
    println()
    println("index values from array")
    for(index in name.indices) {
        println("name[$index] is $name[index]")
    }
    println()
    println("in the range")
            print("for (i in 1..5) print(i) = ")
        for (i in 1..5) print(i)
                println()
                print("for (i in 5..1) print(i) = ")
        for (i in 5..1) print(i)             // prints nothing
                println()
                print("for (i in 5 downTo 1) print(i) = ")
        for (i in 5 downTo 1) print(i)
                println()
                print("for (i in 5 downTo 2) print(i) = ")
        for (i in 5 downTo 2) print(i)
                println()
                print("for (i in 1..5 step 2) print(i) = ")
        for (i in 1..5 step 2) print(i)
                println()
                print("for (i in 5 downTo 1 step 2) print(i) = ")
        for (i in 5 downTo 1 step 2) print(i)
}

