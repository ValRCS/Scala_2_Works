import io.getquill.{SnakeCase, SqliteJdbcContext}
import javax.sql.DataSource

object UsingQuill extends App {
  println("Testing Quill connection")
  //setting up context
  lazy val ctx = new SqliteJdbcContext(SnakeCase, "ctx")
//  ctx.dataSource = new DataSource()
//  ctx.driverClassName=org.sqlite.JDBC
//  ctx.jdbcUrl=jdbc:sqlite:/path/to/db/file.db
//  ctx.dataSource = "jdbc:sqlite:C:/sqlite/db/chinook.db"
//TODO return to see how to add URL

}
