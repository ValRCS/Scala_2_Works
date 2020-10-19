import scala.io.Source

object Array_Manipulation extends App {
  val filePath = "C:/Temp/inp1.txt"
  val lines = Source.fromFile(filePath).getLines.toArray
  lines.foreach(println)
  val n = lines(0).split(" ")(0).toInt
  val m = lines(0).split(" ")(1).toInt
  println(n, m)
  val instructions = lines.drop(1).map(line => line.split(" ").map(_.toInt))
  instructions.foreach(el => println(el.mkString(":")))

  val a = new Array[Int](n+1) // so it means that we can mutate the values inside our immutable size array
  println(a.mkString("|"))
//  instructions.foreach(job => a.slice(job(0)-1,job(1)).foreach(el => el + job(2)))
  instructions.foreach(job => mutateArray(a, job(0), job(1), job(2)))
  println(a.mkString("|"))

  def mutateArray(a: Array[Int], beg: Int, end: Int, delta: Int) ={
    for (i <- (beg-1) until end) {
      a(i) += delta
    }
    a
  }

  val answer = a.max
  println(s"Solution is $answer")
}