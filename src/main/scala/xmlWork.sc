//import scala.xml
<p>My text</p>

import kantan.xpath._           // Basic kantan.xpath types.
import kantan.xpath.implicits._ // Implicit operators and literals.
//import kantan.xpath.nekohtml._  // HTML parsing.
import java.net.URI

//val url = "https://dom.lndb.lv/data/obj/4.xml"
//val url = "https://www.w3schools.com/xml/note.xml"
val url = "https://www.w3schools.com/xml/cd_catalog.xml"
val uri = new URI(url)

//uri.evalXPath[List[Int]](xp"//dom.lndb.lv:subject[@thesaurusId='num']")
//uri.evalXPath[String](xp"//body")
uri.evalXPath[List[String]](xp"CATALOG/CD/TITLE")
res1.toSeq
res2.head
res3.head
res2.foreach(println)
res3.foreach(println)