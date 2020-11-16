import com.redis.RedisClient

object RedisConn extends App{
  println("Connecting to Redis")
  //this should be read from .env file really
  val host = "myhost"
  val port = 10283
  val db = "FunStoreNov20"
  val mysecret = "secret" //FIXME ASAP move to .env

  val r = new RedisClient(host, port, secret = mysecret)
  r.set("name", "Valdis")
  println(r.get("name"))
}
