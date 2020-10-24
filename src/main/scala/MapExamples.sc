val m = Map("one" -> 1, "two" -> 2, "three" -> 3)
m("one")
m("three")
val m2 = Array(("name", "Valdis"),("likes", "biking"), ("loves", "food")).toMap
m2("likes")
val mutableMap = collection.mutable.Map[String, String]() //so I create an empyt mutable map
mutableMap ++= m2
mutableMap
mutableMap("wants") = "sleep"
mutableMap

mutableMap.foreach({ case (k, v) => println(s"key $k -> value : $v") })

mutableMap.getOrElseUpdate("loves", "everything")
mutableMap.getOrElseUpdate("breakfast", "omelet")
mutableMap("name") = "Maija"
mutableMap
mutableMap("likes") = "omelet"
mutableMap

val mutArrMap = collection.mutable.Map[String, Array[String]]()
mutArrMap("name") = Array("Valdis", "Maija", "Liga")
mutArrMap("foods") = Array("Omelet", "Sandwiches", "Porridge")
mutArrMap("foods")(2) // 2 does not guarantee we get the last
mutArrMap("foods")(mutArrMap("foods").size - 1)
mutArrMap("foods").last

mutArrMap.getOrElse("foods", "Default")
mutArrMap.getOrElse("drinks", "Default")
//so getOrElse you can specify what you get when key does not exist
mutArrMap.getOrElseUpdate("drinks", Array("Tea", "Coffee"))
mutArrMap

//so T represents any data type
def iterateOverSomething[T](items: Iterable[T]) = {
  for (i <- items) println(i)
  items.foreach(println)
}

iterateOverSomething(mutArrMap("foods"))
iterateOverSomething(mutArrMap)
//so we see that we can use iterateOverSomething over any type data structure

val mySet = Set(1,2,34,5,1,1,3,2)
iterateOverSomething(mySet)

def getIndexZeroAndTwo[T](items: IndexedSeq[T]) = (items(0), items(2))

getIndexZeroAndTwo(mutArrMap("foods"))
getIndexZeroAndTwo(Vector(1,2,3,4,5))
getIndexZeroAndTwo(mutArrMap("name"))
mutArrMap.get("badkey") //so Map get gives us None when no key exists
mutArrMap.contains("food")
mutArrMap.contains("foods")
mutArrMap.keys
mutArrMap.keySet
mutArrMap.keysIterator //so keysIterator gives us keys on demand when we loop through it
mutArrMap.keysIterator.foreach(println)

//so if you were to write your own class and make it iterable you'd need to implement next
mutArrMap.keysIterator.next()
for (item <- mutArrMap.keysIterator) {
  println(item)
}
//val myIt = mutArrMap.keysIterator
//val it = mutArrMap.keysIterator
//while (it.hasNext)
//  println(it.next())
