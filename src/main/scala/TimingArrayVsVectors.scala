object TimingArrayVsVectors extends App{
  val r = new scala.util.Random(100)
  val t1 = System.nanoTime
  val itCount = 1
  val collSize = 100000000
  println("Timing Vectors vs Array")
  for (i <- 1 to itCount) {
    val myArray = Array.range(1, collSize)
    myArray(5) = r.nextInt()
  }

  val duration = (System.nanoTime - t1) / 1e9d

  val t2 = System.nanoTime
  for (i <- 1 to itCount) {
    val myVector = Vector.range(1, collSize) //creating is quite slow
    val myVector2 = myVector.updated(5, r.nextInt()) //updating is not so bad
  }
  val duration2 = (System.nanoTime - t2) / 1e9d
  println(s"Array basic run time: $duration seconds")
  println(s"Vector run time: $duration2 seconds")

}
