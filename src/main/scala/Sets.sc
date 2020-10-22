for (i <- Set(1, 2, 3, 4, 5)) println(i)
Set(1, 2, 3, 4, 5).foreach(println)

val s1 = Set.range(1,10)
val s2= Set.range(3,7)
val s3= Set.range(5,12)
s1 & s2
s2 | s3
s1 diff s2
s2 diff s1 //should have nothing
s2 diff s3
s3 diff s2
val s4 = Range.inclusive(1,9).toSet