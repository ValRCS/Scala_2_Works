import scala.concurrent.Await

object UsingSlick extends App {
  println("Trying Slick")
  import slick.jdbc.SQLiteProfile.api._ // must import
  val db = Database.forURL(url = "c:/sqlite/db/chinook.db")
//  lazy val db = Database.forURL(url = "c:/sqlite/db/chinook.db") with lazy the function is not called until needed

//  val db = Database.forURL(url = "c:/sqlite/db/chinookbad.db")
//  import scala.concurrent.ExecutionContext.Implicits.global

  //so this code generator should run whenever we change our Database schema
  slick.codegen.SourceCodeGenerator.main(
    Array(
      "slick.jdbc.SQLiteProfile",
      "org.sqlite.JDBC",
      "jdbc:sqlite:C:/sqlite/db/chinook.db",
      "src/main/scala",
      "org.opal.db.model",
      "chinook",
      "test",
    )
  )
}
