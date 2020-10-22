object TimingBranchPrediction extends App {

  import java.util
  import java.util.Random

 // Generate data
    val arraySize = 32768
    val data = new Array[Long](arraySize)
    val rnd = new Random(0)
    for (c <- 0 until arraySize) {
      data(c) = rnd.nextInt % 256
    }
    // !!! With this, the next loop runs faster
    util.Arrays.sort(data)
    // Test
    val start = System.nanoTime
    var sum:Long= 0
//    for (i <- 0 until 100000) { // Primary loop
////      for (c <- 0 until arraySize) {
////        if (data(c) >= 128) sum += data(c)
////      }
////      sum += data.filter(_ >= 128).foldLeft(0)(_ + _)
//      sum += data.filter(_ >= 128).sum
//    }
  sum = data.filter(_ >= 128).sum * 100000
    System.out.println((System.nanoTime - start) / 1000000000.0)
    System.out.println("sum = " + sum)

}
