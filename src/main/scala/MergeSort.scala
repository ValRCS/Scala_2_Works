object MergeSort extends App {
  val arr = Array(1, 3, 6, 2, 6, 16, 7)
  val sortedArr = arr.sorted
  //  for (elem <- sortedArr) {println(elem)}
  println(sortedArr.mkString(","))

  def mergeSort(items: Array[Int]): Array[Int] = {
    if (items.length <= 1) items
    else {
      val (left, right) = items.splitAt(items.length / 2) //split array
      val (sortedLeft, sortedRight) = (mergeSort(left), mergeSort(right)) //unpacking a Tuple
      var (leftIdx, rightIdx) = (0, 0)
      val output = Array.newBuilder[Int]
      while (leftIdx < sortedLeft.length || rightIdx < sortedRight.length) {
        val takeLeft = (leftIdx < sortedLeft.length, rightIdx < sortedRight.length) match {
          case (true, false) => true
          case (false, true) => false
          case (true, true) => sortedLeft(leftIdx) < sortedRight(rightIdx)
        }
        if (takeLeft) {
          output += sortedLeft(leftIdx)
          leftIdx += 1
        } else {
          output += sortedRight(rightIdx)
          rightIdx += 1

        }
      }

      output.result()
    }
  }

  val mSorted = mergeSort(arr)
  println(mSorted.mkString(","))

}
