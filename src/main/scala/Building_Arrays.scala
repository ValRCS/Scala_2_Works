object Building_Arrays extends App {
  val a = for (i <- 1 to 5) yield {i*10}
  a.foreach(println)
  //when we are not sure on how many values we need we can use newBuilder
  //then use result to finalize the array
  val b = Array.newBuilder[Int]
  for (i <- 1 to 5) {
    b += i*100
  }
  val built = b.result()
  built.foreach(println)
}
