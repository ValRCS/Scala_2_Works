//since we are not going to be storing data, just methods, it makes sense that
//this will be an object - a single instance of the class - a singleton object
object PatternMatch {
  def dayOfWeek(x: Int): String = x match {
    case 1 => "Mon"
    case 2 => "Tue"
    case 3 => "Wed"
    case 4 => "Thu"
    case 5 => "Fri"
    case 6 => "Sat"
    case 7 => "Sun"
    case _ => "Unknown"
  }

  def indexOfDay(d: String): Int = d match {
    case "Mon" => 1; case "Tue" => 2
    case "Wed" => 3; case "Thu" => 4
    case "Fri" => 5; case "Sat" => 6
    case "Sun" => 7; case _ => -1
  }

  def getFizzBuzz(beg:Int = 1, end:Int = 100, fizz:Int = 3, buzz:Int = 5): Seq[String] = {
    val result = for (i <- Range.inclusive(beg, end)) yield {
      (i % fizz, i % buzz) match {
        case (0, 0) => "FizzBuzz"
        case (0, _) => "Fizz"
        case (_, 0) => "Buzz"
        case _ => i.toString
      }
    }
    result
  }

  def direction(p: Point): String = p match {
    case Point(0, 0) => "origin"
    case Point(_, 0) => "horizontal"
    case Point(0, _) => "vertical"
    case mp if mp.x > 0 && mp.y > 0 => "Q1" //Pattern Guard example so mp i just made up on the spot
    case mp if mp.x < 0 && mp.y > 0 => "Q2" //Pattern Guard example so mp i just made up on the spot
    case mp if mp.x < 0 && mp.y < 0 => "Q3" //Pattern Guard example so mp i just made up on the spot
    case mp if mp.x > 0 && mp.y < 0 => "Q4" //Pattern Guard example so mp i just made up on the spot
    case _ => "unexpected" //this really should not be possible
  }



  def printFizzBuzz(beg:Int = 1, end:Int = 100, fizz:Int = 3, buzz:Int = 5): Unit = {
    println(getFizzBuzz(beg,end,fizz,buzz).mkString(","))
  }

  def printDay(x: Int): Unit = println(dayOfWeek(x))
  def printIndex(d: String): Unit = println(indexOfDay(d))
}
