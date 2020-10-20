object FunMethods extends App {
  //we've have defined a method which take two paramaters
  //one is an integer and one a function which takes integer and returns integer
  def funRunner(a:Int=300, f: Int => Int) = {
    val result = f(a)
    println(s"Logging some info on $a, the f($a) returned $result") //this could go into a log file, or network stream
    result
  }

  def myAdder(a:Int) = {
    a + 100
  }
  println(funRunner(10, i => i*5))
  println(funRunner(10, myAdder))
  println(funRunner(200, i => i*i))
  println(funRunner(200, _*50)) //shorthand of the above function declaration

}
