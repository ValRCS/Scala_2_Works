import scala.collection.mutable.ListBuffer
// https://www.sqlitetutorial.net/sqlite-sample-database/
// https://alvinalexander.com/scala/scala-jdbc-connection-mysql-sql-select-example/
// https://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/
// driver https://github.com/xerial/sqlite-jdbc

object DBTest extends App{
  println("Testing DB Connection!")
  val url = "jdbc:sqlite:C:/sqlite/db/chinook.db"
  //here you would obtain credentials from your enviroment file for password and username
  //also port name would go here for non SQLite database

  import java.sql.DriverManager

  val conn = DriverManager.getConnection(url)

  val statement = conn.createStatement()
  //  val resultSet = statement.executeQuery("SELECT * FROM ARTISTS LIMIT 10")

  //  val sql =
  //    """
  //      |SELECT  *, COUNT(Total) purc_count,
  //      |SUM(Total), ROUND(AVG(Total),2),
  //      |ROUND(MIN(Total),2),MAX(Total)
  //      |FROM v_buyers vb
  //      |GROUP BY FullName
  //      |ORDER BY SUM(total) DESC
  //      |""".stripMargin
  val sql =
  """
    |SELECT p.Name, COUNT(pt.TrackId) nr_of_tracks FROM playlists p
    |JOIN playlist_track pt
    |ON pt.PlaylistId = p.PlaylistId
    |GROUP BY p.Name
    |ORDER BY nr_of_tracks DESC
    |LIMIT 10
    |""".stripMargin
  //  val resultSet = statement.executeQuery("""
  //       |SELECT v."Month",
  //       |SUM(v.Total) msales, COUNT(v."Month" )
  //       |FROM v_2010 v
  //       |GROUP BY "Month"
  //       |ORDER BY msales DESC""".stripMargin)

  val resultSet = statement.executeQuery(sql)
  val meta = resultSet.getMetaData
  println(meta.getColumnCount)
  var colSeq = ListBuffer[String]()
  for (i <- 1 to
    meta.getColumnCount) {
    println(meta.getColumnName(i))
    colSeq += meta.getColumnName(i)
  }
  println(colSeq)
  //resultSet.next() means it will return some row or false / falsy
  val resultsBuffer = scala.collection.mutable.ListBuffer.empty[Seq[(String,String)]]
  while ( resultSet.next() ) {

    //    colSeq.foreach(col => print(col, resultSet.getString(col)))
    val row = colSeq.map(col => (col, resultSet.getString(col))) //TODO think of other structures to hold data
    resultsBuffer.append(row.toSeq)
    println(row.size)
  }
  val results = resultsBuffer.toSeq
  println(results.size)
  results.foreach(line => println(line.getClass, line.size))
  println(results.getClass)
  val classical = results.filter(line => line(0)._2.startsWith("Classical"))
  classical.foreach(println)

  //  val newResults = results.map(line => line.toSeq)
}