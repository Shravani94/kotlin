fun main(){
    var map1:Map<Any,Any> = mapOf<Any,Any>(1 to "Shravani",2 to "Ranjith","Third" to "Rakesh", '4' to "Harshini","Advaith" to 5)
    for(key in map1.keys)
        println("element at $key ="+map1.get(key))
    println()
    println("get particuar key value")
    println(map1.getValue(2))
    println()
    println("check particular key or  value present in map or not")
    println("this key is present"+map1.containsKey(5))
    println("this value is present"+map1.containsValue("Shravani"))
    println()
    println("getting default value")
    println("the default value is"+map1.getOrDefault(4,"Harshini"))
    println()
    println("using asIterable iterating the map")
    for(itr in map1.asIterable())
        println("key =${itr.key} and value =${itr.value}")
    println()
    println("using iterator iterating the map")
    for(itr in map1.iterator())
        println("key is =${itr.key} amd value is =${itr.value}")
    println()
    println("By using minus operator")
    for(mns in map1.minus(1))
        println("remaining are ${map1[mns.key]}")
    println()
    println("By using plus operation")
    for(pus in map1.plus(Pair(1,"Shravani")))
        println("value is = ${map1[pus.key]} and key is =$pus")
}