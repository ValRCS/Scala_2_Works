class MyTrie {
  class Node(var hasValue: Boolean,
             val children: collection.mutable.Map[Char, Node] = collection.mutable.Map())
  val root = new Node(false)
  def add(s: String):Unit= {
    var current = root
    for (c <- s) current = current.children.getOrElseUpdate(c, new Node(false))
    current.hasValue = true
  }
  def contains(s: String): Boolean = {
     var current = Option(root)
     for (c <- s if current.nonEmpty) current = current.get.children.get(c)
     current.exists(_.hasValue)
   }

   def prefixesMatchingString0(s: String): Set[Int] = {
     var current = Option(root)
     val output = Set.newBuilder[Int]
     for ((c, i) <- s.zipWithIndex if current.nonEmpty) {
       if (current.get.hasValue) output += i
       current = current.get.children.get(c)
       }
     if (current.exists(_.hasValue)) output += s.length
     output.result()
     }

  def printAll() = {
    var current = Option(root)
    //start with printing just one random word
    //you are guarantedd to print something because all the leaves in the Trie have x in the end(hasValues
    //so need string builder and print whenever there is hasValue

  }
}