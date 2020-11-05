import upickle.default._
object Parsing_JSON_Nov5 extends App {
  //TODO parse MOCK_DATA.json
  //Get gender balance Male/Female
  //Get most popular first names
  val fileName = "MOCK_DATA.json"
  val jsonString = os.read(os.pwd / "src" / "resources" / fileName)
  println(jsonString.size)
  val jsonBlob = read[ujson.Value](jsonString)
  val seqMap = read[Seq[Map[String,ujson.Value]]](jsonString)

  def getPersonSeq(seqMap:Seq[Map[String,ujson.Value]]) : Seq[APerson] = {
    //FIXME
    Seq(APerson(9000, "Valdis", "Saulespurens", "valdis.saulespurens@gmail.com", "Male", "127.0.0.1"))
  }
  val personSeq = getPersonSeq(seqMap)

  //TODO filter values out
}

case class APerson(id:Int,first_name:String,last_name:String,email:String,gender:String,ip_address:String)