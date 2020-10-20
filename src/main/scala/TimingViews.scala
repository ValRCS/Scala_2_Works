object TimingViews extends App {
  val r = new scala.util.Random(100)
  val t1 = System.nanoTime
  for (i <- 1 to 10000000) {
    val myArray = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val myNewArray = myArray.map(x => x + r.nextInt(10)).filter(x => x % 2 == 0).slice(1, 3)
  }

  val duration = (System.nanoTime - t1) / 1e9d

  val t2 = System.nanoTime
  for (i <- 1 to 10000000) {
    val myArray = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val myFusedArray = myArray.view.map(_ + r.nextInt(10)).filter(_ % 2 == 0).slice(1, 3).to(Array)
  }
  val duration2 = (System.nanoTime - t2) / 1e9d
  println(s"Array basic run time: $duration seconds")
  println(s"View run time: $duration2 seconds")
}
