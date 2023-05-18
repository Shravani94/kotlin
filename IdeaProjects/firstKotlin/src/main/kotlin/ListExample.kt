fun main(){
    var list= listOf<Any>(1,2,3,4,"Sravani","Ruksana","babu")
    var stringList: List<String> = listOf<String>("Ajay","Vijay","Prakash","Vijay","Rohan")
    var intList: List<Int> = listOf(1,2,3,4,5,6)

/*
    var list2:List<String>=listOf<String>("sravani","harshini","advaith","Ranjith","Rakesh")
*/
    for(arr in list){
        println(arr)
    }
    println()
    println("using range opeartor from acessending order ")
    for(arr in 0..list.size-1)
        println(list[arr])
    println()
    println("using range operator in decssending order")
    for(arr in list.size-1..0)
        println(list[arr])
    println()
    println("list of list1 elements")
    for(arr in stringList)
        println(arr)
    println()
    println("list of list2 elements")
    for(arr in intList)
        println(arr)
    println()
    println("performing all operations")
    println(list)
    println(list.size)
    println(list.get(5))
    println(list.indexOf("babu"))
    println(list.isEmpty())
    println(list.contains("raju"))
    println(list.lastIndexOf("rakesh"))
    println(list.dropLast(5))
    println(list.containsAll(list))
    println(list.subList(1,4))
    //println(listOfNotNull())

}