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

isValidSudoku(Array(
  Array(5, 3, 4,  6, 7, 8,  9, 1, 2),
  Array(6, 7, 2,  1, 9, 5,  3, 4, 8),
  Array(1, 9, 8,  3, 4, 2,  5, 6, 7),

  Array(8, 5, 9,  7, 6, 1,  4, 2, 3),
  Array(4, 2, 6,  8, 5, 3,  7, 9, 1),
  Array(7, 1, 3,  9, 2, 4,  8, 5, 6),

  Array(9, 6, 1,  5, 3, 7,  2, 8, 4),
  Array(2, 8, 7,  4, 1, 9,  6, 3, 5),
  Array(3, 4, 5,  2, 8, 6,  1, 7, 9)
))

//TODO how to modify this function to check for 0 when unfilled,

//that is valid grids which are not completed

// Converters
val v1 = Array(1, 2, 3).to(Vector)
val v2 = Array(1, 2, 3).toVector
v1(2)
//v1(2) = 500

val a1 = Vector(1, 2, 3).to(Array)
val a2 = Vector(1, 2, 3).toArray
a2(2) = 50

//So if you want mutable sequence use Array
//If you want immutable sequences use Vector

// Views

val myArray = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
val myNewArray = myArray.map(x => x + 100).filter(x => x % 2 == 0).slice(1, 3)

//so create view then do stuff then cast to Array
val myFusedArray = myArray.view.map(_ + 100).filter(_ % 2 == 0).slice(1, 3).to(Array)

//TODO Create 100 000 Vectors of say 100 size and do map and filter on them
//TODO Same for Arrays - my hypothesis is that Arrays will be fASTER
//Time it
