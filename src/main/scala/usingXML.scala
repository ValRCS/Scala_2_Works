import scala.xml.XML.{loadFile, save}

object usingXML extends App {
  val p = <p>Text</p>
//  println(p)
  val body = <body>my own body text <p>some p text</p><p>more paragraph text</p></body>
//  println(body)
//  val book = <book category="children">
//    <title lang="en">Harry Potter</title>
//    <author>J K. Rowling</author>
//    <year>2005</year>
//    <price>29.99</price>
//  </book>
//  println(book)
  val evalEl = <a> Answer to 5+5 = {5+5} &gt; 2</a>
//  println(evalEl)
//  println(evalEl.text)
  val nestedEl = <div>{body}{evalEl}</div>
//  println(nestedEl)
  //of course you should be careful with allowing user supplied strings inside {} potential security hole
//  println(body.text) // notice it prints ALl text inside body and its children
//  println(book \ "author")
//  println((book \ "author").text)

  val bookstore = loadFile("./src/resources/book.xml") // built in xml loading AND parsing
//  println(bookstore)
  val books = bookstore \ "book"
//  println(books)
//  println(books(0))
//  val prices = for (book <- books) yield book \ "price" //one way of extracting prices
  val prices = for (book <- books) yield (book \ "price").text.toDouble //one way of extracting prices
//  prices.foreach(println)
  //below you are saying you want all prices you do not care for which element  they are
  // so \\ is like a wildcard going as deep into XML as needed
  // for huge XML this can take some time
  val dirPrices = (bookstore \\ "price").map(it => it.text.toDouble)
//  dirPrices.foreach(println)
//  val hp = (bookstore \ "books").filter(item => item.attribute.get("category") == "children")
//  val hp = books.filter(_.attribute("category").contains("children")) //TODO flatten
//  hp.foreach(println)
val hp = (bookstore \\ "book" filter { _ \\ "@category" exists (_.text == "children")}).text
//  println(hp)
  val webBooks = (bookstore \\ "book" filter { _ \\ "@category" exists (_.text == "web")}).text
//  println(webBooks)
//  println(books.head.attribute("category"))
//  println(books.head.attributes)
//  val cat = books.head.attribute("category")
//  println(cat)

  val myBook = new Book {
    val category = "childrens"
    val title = "Happy Potter"
    val titleLang = "en"
    val authors = List("J.K. Rowling")
    val year = 1997
    val price = 19.95
  }
  println(myBook.toXML)
  save("./src/resources/mybook.xml", myBook.toXML, xmlDecl = true)
}
