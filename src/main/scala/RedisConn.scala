import com.redis.RedisClient

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
}
