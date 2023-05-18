fun main(){
    var a=20;
    var b=30;
    var c=20;
    var d=35;
    if(a.equals(c)){
        println("Both are equal")
        if(a>d){
            println("$a is greater")
        }
        else if(d>c){
            println("$d is greater")
        }
        else if(b>d){
            println("$d is gretaer")
        }
        else{
            println("$d is greater")
        }

    }
    else{
        println("not eqaul")
    }
}