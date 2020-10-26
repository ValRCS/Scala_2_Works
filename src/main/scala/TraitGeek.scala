object TraitGeek extends App {




  // Creating object
  object GFG
  {
    // Main method
    def main(args: Array[String])
    {
      val s = new Scala
      val j = new Java
      val c = new Csharp
      println(checkArticle(s))
      println(checkArticle(j))
      println(checkArticle(c))
    }

    // Defined function
    def checkArticle(Article: Geeks): String = Article match
    {
      case s: Scala  => s.article
      case j: Java   => j.article
      case c: Csharp => c.article
      //exclusion of <strong>line 45</strong> would lead to warning
    }
  }
  GFG.main(Array())
}
