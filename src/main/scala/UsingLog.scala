//import com.typesafe.scalalogging.Logger
//import grizzled.slf4j.Logger
import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

object UsingLog extends App {
  println("Let's try some logging")
  val expensive = 5555
//  val logger = Logger("UsingLog") //
//  logger.info("Hello, world")
  val logger = Logger("myUsingLog")
////  val logger = Logger(LoggerFactory.getLogger("mylogname"))
  logger.debug(s"Some $expensive message!")
  logger.info("Test")
  //error you would log when there is an error happening
  logger.error("Danger we got an error!")
  logger.warn("Warning")


  def environmentVariables = {
    import scala.collection.JavaConverters._
    import scala.language.implicitConversions
    val environmentVars = System.getenv().asScala
    for ((k,v) <- environmentVars) println(s"key: $k, value: $v")

    val properties = System.getProperties().asScala
    for ((k,v) <- properties) println(s"key: $k, value: $v")
  }
//  environmentVariables

  def printClassPath() = {
    import java.lang.ClassLoader
    val cl = ClassLoader.getSystemClassLoader
    cl.asInstanceOf[java.net.URLClassLoader].getURLs.foreach(println)
  }
//  printClassPath()
}


