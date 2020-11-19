import CassandraExample.cassandraExample
import com.datastax.driver.core.{PlainTextAuthProvider, SocketOptions}
import com.outworkers.phantom.dsl._

object UsingCassandra extends App {
  println("Using Cassandra")
//  host: String, port: Int, username: String, password: String, caPath: String
  val host = "cassandra-yours.aivencloud.com"
  val port = 13238
  val username = "avnadmin"
  val password = "yourpw"
//  val caPath = "C:\\certs\\"
  val caPath = "./src/resources/ca.pem"

  cassandraExample(host=host,port=port,username=username,password=password, caPath=caPath)
  println("Lets hold fingers crossed")

//  val default: CassandraConnection = ContactPoint.local
//    .withClusterBuilder(_.withSocketOptions(
//      new SocketOptions()
//        .setConnectTimeoutMillis(20000)
//        .setReadTimeoutMillis(20000)
//    )
//    ).noHeartbeat().keySpace(
//    KeySpace("phantom").ifNotExists().`with`(
//      replication eqs SimpleStrategy.replication_factor(1)
//    )
//  )

}
