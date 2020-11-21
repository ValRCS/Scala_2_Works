object UsingNeo4J extends App {
  println("Will connnect to Neo4J")

  import neotypes.GraphDatabase
//  import neotypes.generic.auto._
  import neotypes.implicits.syntax.all._
  import org.neo4j.driver.AuthTokens
  import scala.concurrent.{Await, Future}
  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.concurrent.duration._

  val user = "neo4j"
  val pw = "changeme" //TODO get it from enviroment not hard code it
  val host = "52.4.89.242"
  val port = 37125
  val driver = GraphDatabase.driver[Future](s"bolt://$host:$port", AuthTokens.basic(user, pw))
  val session = driver.session

//  val people = "match (p:Person) return p.name, p.born limit 10".query[(String, Int)].list(session)
//  Await.result(people, 1.second)
  // res: Seq[(String, Int)] = ArrayBuffer((Charlize Theron,1975), (Keanu Reeves,1964), (Carrie-Anne Moss,1967), (Laurence Fishburne,1961), (Hugo Weaving,1960), (Lilly Wachowski,1967), (Lana Wachowski,1965), (Joel Silver,1952), (Emil Eifrem,1978), (Charlize Theron,1975))

  final case class Person(id: Long, born: Int, name: Option[String], notExists: Option[Int])

//  val peopleCC = "match (p:Person) return p limit 10".query[Person].list(session)
//  Await.result(peopleCC, 1.second)
  // res: Seq[Person] = ArrayBuffer(Person(0,1975,Some(Charlize Theron),None), Person(4,1964,Some(Keanu Reeves),None), Person(5,1967,Some(Carrie-Anne Moss),None), Person(6,1961,Some(Laurence Fishburne),None), Person(7,1960,Some(Hugo Weaving),None), Person(8,1967,Some(Lilly Wachowski),None), Person(9,1965,Some(Lana Wachowski),None), Person(10,1952,Some(Joel Silver),None), Person(11,1978,Some(Emil Eifrem),None), Person(15,1975,Some(Charlize Theron),None))

  session.close
  driver.close
  println("Should be done with the connection to Neo4J")

}
