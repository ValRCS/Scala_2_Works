class MyTimer {
  var startTime:Long = 0
  var durationTime = 0.0
  def start(): Long = {
    startTime = System.nanoTime
    startTime
  }

  def stop(): Double = {
    durationTime = (System.nanoTime - startTime) / 1e9d
    durationTime
  }

  def prettyPrint(): Unit = println(s"Program run time: $durationTime seconds")

  //so a good way of testing so => delays the evaluation of f
  def measureTime(f: => Unit): Long = {
//    val start = System.currentTimeMillis()
    val start = System.nanoTime
    f
//    val end = System.currentTimeMillis()
    val end = System.nanoTime
    val delta = end - start
//    println(s"Evaluation took $delta nanoseconds which is ${delta/1000000000d} seconds")
    delta
  }
  }

