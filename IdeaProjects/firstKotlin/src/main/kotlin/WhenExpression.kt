import java.util.Scanner

fun main(){
    println("enter the number")
    val read=Scanner(System.`in`)
    var num=read.nextInt()
    println("with one statement")
    var first=when(num){
        1->println("sunday")
        2->println("monady")
        3->println("thuesday")
        4->println("wednesday")
        5->println("thursday")
        6->println("friday")
        7->println("saturday")
        else->println("enter valid number")
    }
    println()
    println("with mutiple statements")
    var second=when(num){
        1->{
            println("this is sunday")
            println("weekend")
        }
        2->{
            println("this is monday")
            println("workingday")
        }
        3->{
            println("this is thuesday")
            println("working day")
        }
        4->{
            println("this is wednesday")
            println("working day")
        }
        5->{
            println("this is thursday")
            println("working day")
        }
        6->{
            println("this is friday")
            println("working day")
        }
        7->{
            println("this is saturday")
            println("wweekend")
        }
        else->{
            println("enter valid number")
        }
    }
    println()
    println("with multiple branches")
    var third=when(num){
        2,3,4,5,6->{
            println("these are working days")
        }
        1,7->{
            println("these are weekends ")

        }
        else->{
            println("enter valid nnumber")
        }
    }
    println()
    println("range satements")
    var fourth=when(num){
        in  2..7->{
            println("working days")
    }
        else->{
            println("valid number")
    }
    }
}