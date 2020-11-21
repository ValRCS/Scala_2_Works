import org.neo4j.driver._
import org.neo4j.driver.Values.parameters
import java.util
import java.util.Arrays.asList
import java.util.Collections.singletonMap


object UsingNeo4Java extends App {

  import org.neo4j.driver.AuthTokens

  def main(args: String*): Unit = {
    println("Starting our Connection to Neo4J")
//    val noSSL = Config.builder.withEncryptionLevel(Config.EncryptionLevel.NONE).toConfig
    val noSSL = Config.builder().build() //TODO possible need to set Encryption Level to None


    val driver = GraphDatabase.driver("bolt://52.4.89.242:37125", AuthTokens.basic("neo4j", "changme"), noSSL) // <password>
    try {
      val session = driver.session
      try {
//        val cypherQuery = "MATCH (n) " + "RETURN id(n) AS id"
        val cypherQuery = "MATCH (m:Movie) " + "RETURN m.title AS title, id(m) as id"
        val result = session.run(cypherQuery, parameters()) //TODO check if parameters need values
        while ( {
          result.hasNext
        }) {
          val record = result.next // so somewhat similar to row in SQL one entry
//          System.out.println(result.next.get("id"))
          println(record.get("id"), record.get("title"))
        }
      } finally if (session != null) session.close()
    }
  }
  main()
}
