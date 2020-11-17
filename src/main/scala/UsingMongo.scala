import java.lang.Thread.sleep

import org.mongodb.scala.MongoClient
import org.mongodb.scala._
import org.mongodb.scala.model.Filters._
import org.mongodb.scala.model.Projections._
import org.mongodb.scala.model.Sorts._

object UsingMongo extends App{
  println("Using MongoDB")
  val pw = "nov172020"
  val dbname = "sample_restaurants"
  val uri: String = s"mongodb+srv://vadmin:$pw@cluster0.qabwl.mongodb.net/$dbname?retryWrites=true&w=majority"
  System.setProperty("org.mongodb.async.type", "netty")
  val client: MongoClient = MongoClient(uri)
  val db = client.getDatabase("sample_restaurants")
  println("Hmm we should be ready to send some queries")
  println( db.name)
  val collection = db.getCollection("restaurants")
  collection.find().productIterator.foreach(println)
  sleep(5000)
  client.close()
}
