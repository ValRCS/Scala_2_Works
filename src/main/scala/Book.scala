abstract class Book {
  val category: String
  val title: String
  val titleLang: String //perhaps some sort of option, predefined languages
  val authors: List[String] //we could have multiple authors
  val year: Int //could also use some date format
  val price: Double //possibly some money related format

  //toString is built in already so we override
  override def toString = s"${authors.head}: $category $title in $titleLang from $year"

  //TODO investigate how to add newline when saving list of elements
  def getAuthorSeq() =
    for (author <- authors) yield <author>{author}</author>

  //TODO add attributes and author list
  def toXML = <book category="children">
    <title lang="en">{title}</title>
    {getAuthorSeq()}
    <year>{year}</year>
    <price>{price}</price>
  </book>
}
