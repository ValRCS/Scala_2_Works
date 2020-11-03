import upickle.default._

object UsingUPickle extends App{
  println("Let's work with some JSON!")

  println(write(Seq(1, 2, 3))) //so we gain an ability to encode our Scala data structures into JSON strings


  def getNumbers(beg: Int=1, end:Int=10) = {
    val mySeq = for (i <- beg to end) yield Seq(i, i*i, i*i*i)
    mySeq
  }

  println(write(getNumbers()))

  //TODO print JSON of a list of Maps with each map containing key number->value, square->value squared and
  //cube -> number cubed

}
