object TimingCreation extends App {
  val mt = new MyTimer()
//  mt.measureTime(Array(1,2,3,4))
//  mt.measureTime(5+5)
//  mt.measureTime(2.0+3.5)
//  mt.measureTime(Vector(1,2,3,5))
  def myLoop(endVal: Int = 1000): Unit = {
    for (i <- 1 to endVal) {
      i*500 // if operation do not lead to anything, there is a danger that JVM will optimize them away
    }
  }
//  mt.measureTime(myLoop(50000))
//  mt.measureTime(myLoop(1000000))
//  mt.measureTime(myLoop(1000000000))
//
//  mt.measureTime(Range(1, 1000).toArray)
//  mt.measureTime(Range(1, 1000).toList)
//  mt.measureTime(Range(1, 1000).toSeq)
//  mt.measureTime(Range(1, 1000).toVector)

  val nrOfLoops = 1000
  val collectionSize = 1000

  var timeArray: Long = 0
  var timeList: Long = 0
  var timeSeq: Long = 0
  var timeVector: Long = 0

  for(i <- 1 to nrOfLoops) {
//    timeArray += mt.measureTime(Range(1, collectionSize).toArray.apply(55))
//    timeList += mt.measureTime(Range(1, collectionSize).toList.apply(55))
//    timeSeq += mt.measureTime(Range(1, collectionSize).toSeq.apply(55))
//    timeVector += mt.measureTime(Range(1, collectionSize).toVector.apply(55))
    timeArray += mt.measureTime(Range(1, collectionSize).toArray)
    timeList += mt.measureTime(Range(1, collectionSize).toList)
    timeSeq += mt.measureTime(Range(1, collectionSize).toSeq)
    timeVector += mt.measureTime(Range(1, collectionSize).toVector)
  }

  val myCollections = Array(timeArray, timeList, timeSeq, timeVector)

  myCollections.foreach(col => println(s"Average time: ${col / nrOfLoops} nanoseconds"))
}
