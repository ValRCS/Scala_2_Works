object ByNameArguments extends App {
  var logLevel = 1
  def log(level: Int, msg: => String) = {
    println("log function")
    if (level > logLevel) println(msg)
  }
  log(2, "Hello " + 123 + " World")
  logLevel = 3
  log(2, "Hello " + 123 + " World")

  //so this is a small optimization, you save CPU time spent on evaluation arguments which are not used
}
