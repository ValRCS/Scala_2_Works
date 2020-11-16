import com.redis.RedisClient
import java.net._
import java.io._
import scala.collection.mutable.ArrayBuffer

object RedisConn extends App{
  println("Connecting to Redis")
  val host = scala.util.Properties.envOrElse("REDISHOST", "undefined") //of course care must be taken for name colission
  println(s"My host is $host")
  val port = 10283
  val db = "FunStoreNov20"
  val secret = scala.util.Properties.envOrElse("REDISPW", "nosuchsecret")

  val r = new RedisClient(host, port, 0, Some(secret))
  r.set("name", "Valdis")
  println(r.get("name"))

  def getText(uri: String) = {
    val url = new URL(uri)
    val in = new BufferedReader(new InputStreamReader(url.openStream))
    val buffer = new ArrayBuffer[String]()
    var inputLine = in.readLine
    while (inputLine != null) {
      if (!inputLine.trim.equals("")) {
        buffer += inputLine.trim
      }
      inputLine = in.readLine
    }
    in.close
    buffer.toArray
  }

  def readFile(fname:String): Map[String, Int] ={
    val counter = scala.io.Source.fromFile(fname)
      .getLines
      .flatMap(_.split("\\W+"))
      .foldLeft(Map.empty[String, Int]){
        (count, word) => count + (word -> (count.getOrElse(word, 0) + 1))
      }
    counter
  }

//  val myText = getText("http://www.gutenberg.org/files/11/11-0.txt")
//  val myText = getText("file://./src/resources/alice.txt")
//  println(myText.size)
  val counter = readFile("./src/resources/alice.txt")
  println(counter("rabbit"))
  //this would need to be optimized to chunk (meaning group the sets or gets together
//  counter.foreach(item => r.set("name", "Valdis"))
  r.set("rabbit", counter("rabbit"))
  r.set("Rabbit", counter("Rabbit"))
  r.set("Alice", counter("Alice"))
  println(r.mget("rabbit", "Rabbit", "Alice"))

}
