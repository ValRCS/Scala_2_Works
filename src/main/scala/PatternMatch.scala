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



  def printDay(x: Int): Unit = println(dayOfWeek(x))
  def printIndex(d: String): Unit = println(indexOfDay(d))
}
