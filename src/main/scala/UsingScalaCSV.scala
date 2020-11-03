import java.io.File

import com.github.tototoshi.csv.CSVReader

object UsingScalaCSV extends App {
  println("Going to read some files")
//  val filePath = "./src/resources/sample.csv"
  val filePath = "./src/resources/with-headers.csv"
  val reader = CSVReader.open(new File(filePath))
//  val res = reader.all()
//  res.foreach(line => println(line.mkString(",")))

  //as with most streams you only read it once
  val resMap = reader.allWithHeaders()
  resMap.foreach(myMap => for ((k,v) <- myMap) println(s"key: $k, value: $v"))
}
