import PatternMatch.printIndex
import PatternMatch.direction
// https://alvinalexander.com/scala/how-to-rename-members-import-scala-classes-methods-functions/
import PatternMatch.{printDay => pD}

object UsingPatternMatch extends App {


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

  def randomRange(beg:Int, end:Int, seed: Int = 42) :Int = {
    val r = new scala.util.Random(seed) // specific seed values will always gives as same pseudorandom numbers
    0 //FIXME
  }

  val points = for (i <- Range.inclusive(1,10)) yield Point(randomRange(-5,5),randomRange(-5, 5))
  points.foreach(pt => println(pt, direction(pt)))



}
