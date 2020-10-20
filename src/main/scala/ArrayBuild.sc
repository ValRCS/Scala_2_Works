Array.fill(5)("Jump! ")
Array.tabulate(5)(n => s"hello $n")

Array(1, 2, 3, 4, 5).map(i => i * 2)
Array(1, 2, 3, 4, 5).filter(i => i % 2 == 1)
Array(1, 2, 3, 4, 5).take(2)
Array(1, 2, 3, 4, 5).drop(2)
Array(1, 2, 3, 4, 5).slice(1, 4) // Keep elements from index 1-3
Array(1, 2, 3, 4, 5, 4, 3, 2, 1, 2, 3, 4, 5, 6, 7, 8).distinct
//so find will give us first found unlike filter
Array(1, 2, 3, 4, 5, 6, 7,8).find(i => i % 2 == 0 && i > 4)
Array(1, 2, 3, 4, 5, 6, 7,8).find(i => i % 5467 == 0 && i > 400)
Array(1, 2, 3, 4, 5, 6, 7).exists(x => x > 1)
Array(1, 2, 3, 4, 5, 6, 7).exists(_ < 0) // same as a.exists(x => x < 0)
//Aggregrations
Array(1, 2, 3, 4, 5, 6, 7).mkString(",")
Array(1, 2, 3, 4, 5, 6, 7).mkString("***[", ":", "]***")

// Folding
Array(1, 2, 3, 4, 5, 6, 7).foldLeft(9000)((x, y) => x + y)
Array(1, 2, 3, 4, 5, 6, 7).foldLeft(9000)((_ + _))

// Grouping

val grouped = Array(1, 2, 3, 4, 5, 6, 7).groupBy(_ % 2)
grouped
grouped(1)
//val grpMap = grouped.map((key,arr) => (s"Key $key:", arr))
//TODO for mapping grouped into a Map of str keys with arrays as values
Range(1,50).toArray.groupBy(_ % 5)

def stdDev(a: Array[Double]): Double = {
  val mean = a.foldLeft(0.0)(_ + _) / a.length
  val squareErrors = a.map(_ - mean).map(x => x * x)
  math.sqrt(squareErrors.foldLeft(0.0)(_ + _) / a.length)
}

stdDev(Range(1,10).toArray.map(el => el.toDouble))
//stdDev(Range(1,10).toArray)

def isValidSudoku(grid: Array[Array[Int]]): Boolean = {
  !Range(0, 9).exists{i =>
    val row = Range(0, 9).map(grid(i)(_))
    val col = Range(0, 9).map(grid(_)(i))
    val square = Range(0, 9).map(j => grid((i % 3) * 3 + j % 3)((i / 3) * 3 + j / 3))
    row.distinct.length != row.length ||
      col.distinct.length != col.length ||
      square.distinct.length != square.length
  }
}

//TODO how to modify this function to check for 0 when unfilled,

//that is valid grids which are not completed