import scala.xml.{Elem, Node, NodeSeq}
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

  //TODO extra checks for possible missing attributes and elements
  def getBookFromEl(el:Node): Book = {
    new Book {
      val category = (el \ "@category").text
      val title = (el \ "title").text
      val titleLang = (el \ "title" \ "@lang").text
      val authors = (el \ "author").toList.map(_.text)
      //avoid magic numbers define the defaults somewhere
      val year = if ((el \ "year").isEmpty) 2048 else (el \ "year").text.toInt
      val price = (el \ "price").text.toDouble
    }
  }
//  val book1 = getBookFromEl(books(0))
//  print(book1)

  //deserialization of XML into our internal data forma
  def getBookList(bookNodes: NodeSeq): Seq[Book] = {
    for (book <- bookNodes) yield getBookFromEl(book)
  }
  val bookList = getBookList(books)
  bookList.foreach(println)

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
  val webBooks = bookstore \\ "book" filter { _ \\ "@category" exists (_.text == "web")}
//  //so we can save our book collection by adding some parent element for example root
//  save("./src/resources/webBooks.xml", <bookstore>{webBooks}</bookstore>, xmlDecl = true)

//  println(webBooks)
//  println(books.head.attribute("category"))
//  println(books.head.attributes)
//  val cat = books.head.attribute("category")
//  println(cat)

  val myBook = new Book {
    val category = "childrens"
    val title = "Happy Potter"
    val titleLang = "en"
    val authors = List("J.K. Rowling","Richard Galbraith")
    val year = 1997
    val price = 19.95
  }
//  println(myBook.toXML)
//  save("./src/resources/mybook.xml", myBook.toXML, xmlDecl = true)
}
