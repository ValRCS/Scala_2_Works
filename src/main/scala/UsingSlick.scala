import scala.concurrent.Await

object UsingSlick extends App {
  println("Trying Slick")
  import slick.jdbc.SQLiteProfile.api._ // must import
  lazy val db = Database.forURL(url = "c:/sqlite/db/chinook.db")
//  import scala.concurrent.ExecutionContext.Implicits.global

  //db.run TODO
}
