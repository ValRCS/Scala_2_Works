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

