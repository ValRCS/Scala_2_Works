object TimingCreation extends App {
  val mt = new MyTimer()
  mt.measureTime(Array(1,2,3,4))
  mt.measureTime(5+5)
  mt.measureTime(2.0+3.5)
  mt.measureTime(Vector(1,2,3,5))
  def myLoop(endVal: Int = 1000) = {
    for (i <- 1 to endVal) {
      i*500 // if operation do not lead to anything, there is a danger that JVM will optimize them away
    }
  }
  mt.measureTime(myLoop(50000))
  mt.measureTime(myLoop(1000000))
  mt.measureTime(myLoop(1000000000))
}
