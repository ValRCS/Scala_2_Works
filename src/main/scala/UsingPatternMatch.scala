import PatternMatch.printIndex
import PatternMatch.direction
// https://alvinalexander.com/scala/how-to-rename-members-import-scala-classes-methods-functions/
import PatternMatch.{printDay => pD}

object UsingPatternMatch extends App {
  val r = new scala.util.Random(0) // specific seed values will always give same pseudorandom numbers

  PatternMatch.printDay(4)
  PatternMatch.printDay(70)
  pD(6) // these kind of short names should be used when there is no confusion on their meaning

  PatternMatch.printIndex("Saturday")
  PatternMatch.printIndex("Sat")
  printIndex("Sat")

  PatternMatch.printFizzBuzz(end=20)

  val p = Point(0,0)
  val p2 = p.copy(x = 30)
  val p3 = p.copy(y = 40)
  val p4 = p.copy(x = 10, y = 20)
  println(direction(p))
  println(direction(p2))
  println(direction(p3))
  println(direction(p4))

  def randomRange(beg:Int, end:Int) :Int = {

    beg + r.nextInt((end - beg) + 1)
  }

//  val points = for (i <- Range.inclusive(1,10)) yield Point(randomRange(-5,5),randomRange(-5, 5))
  val points = for (i <- Range.inclusive(1,10)) yield Point(r.between(-5,5+1),r.between(-5,5+1))
  points.foreach(pt => println(pt, direction(pt)))

  println(PatternMatch.splitDate("24-October-2020"))
  println(PatternMatch.splitDate("24-NotAFulldate"))

  PatternMatch.greet(Person("Valdis Saulespurens", "Mr."))
  PatternMatch.greet(Person("Jautrīte", "Miss"))

  PatternMatch.greet2(Person("James Bond", "Mr."), Person("Jane Bond", "Mrs."))
  PatternMatch.greet2(Person("James Bond", "Mr."), Person("Jane Fonda", "Mrs."))
  PatternMatch.greet2(Person("Kim Philby", "Mr."), Person("Kim Bassinger", "Mrs."))

//  for (i <- 0 until points.size) {
//    for (j <- i+1 until points.size) {
//      PatternMatch.matchDistance(points(i), points(j))
//    }
//  }
  val myList = points.combinations(2).toList
  myList.foreach(t => PatternMatch.matchDistance(t(0), t(1)))
//    .foreach(tup => PatternMatch.matchDistance(tup._1, tup._2))
  myList.foreach(println)
  //TODO how could we check all two item combinations in a sequence (Array)

}
