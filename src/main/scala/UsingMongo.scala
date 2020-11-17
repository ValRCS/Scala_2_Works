import java.lang.Thread.sleep

import org.mongodb.scala.MongoClient
import org.mongodb.scala._
import org.mongodb.scala.model.Filters._
import org.mongodb.scala.model.Projections._
import org.mongodb.scala.model.Sorts._
import org.slf4j.LoggerFactory

object UsingMongo extends App{
  println("Using MongoDB")
  import ch.qos.logback.classic.Level
  import ch.qos.logback.classic.LoggerContext

  //so we can set logging level for this application only
//  LoggerFactory.getILoggerFactory.asInstanceOf[LoggerContext].getLogger("org.mongodb.driver").setLevel(Level.DEBUG)
  LoggerFactory.getILoggerFactory.asInstanceOf[LoggerContext].getLogger("org.mongodb.driver").setLevel(Level.ERROR)
  val user = "needsuser"
  val pw = "needspw"
  val dbname = "sample_restaurants"

  val uri: String = s"mongodb+srv://$user:$pw@cluster0.qabwl.mongodb.net/$dbname?retryWrites=true&w=majority"
  System.setProperty("org.mongodb.async.type", "netty")
  val client: MongoClient = MongoClient(uri)
  val db = client.getDatabase("sample_restaurants")
  println("Hmm we should be ready to send some queries")
  println( db.name)
//  val collection = db.getCollection("restaurants")
//  collection.find().productIterator.foreach(println)
    val collection = db.getCollection("restaurants")
    db.listCollectionNames().foreach(println)
//    collection.find().foreach(println) // so similar to SELECT * FROM restaurants
    val chinese = collection.find(equal("cuisine", "Chinese"))//so this example of
//    chinese.foreach(println)
  val brooklyn_chinese = collection.find(and(equal("borough", "Brooklyn"),equal("cuisine", "Chinese")))//so this example of
//  brooklyn_chinese.foreach(println)
  //SELECT * FROM restaurants WHERE cuisine = "Chinese" AND "borough" = "Brooklyn"
  val high_scores = collection.find(and(equal("borough", "Brooklyn"),
    equal("cuisine", "Chinese")
//    ,gte("restaurant_id", 9000) //so greater or equal to 40350045
  ))
  high_scores.foreach(println)
  sleep(5000)
  client.close()
}
