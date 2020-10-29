class MyTrie {
  class Node(var hasValue: Boolean,
             val prefix: String,
             val parent: Option[Node],
             val children: collection.mutable.Map[Char, Node] = collection.mutable.Map())
  val root = new Node(false, prefix = "", parent = None)
  def add(s: String):Unit= {
    var current = root
    for (c <- s) current = current.children.getOrElseUpdate(c, new Node(false, prefix = current.prefix + c, parent = Some(current)))
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

  def printAll(): Unit = {
    //start with printing just one random word
    //you are guarantedd to print something because all the leaves in the Trie have x in the end(hasValues
    //so need string builder and print whenever there is hasValue
    //we will be using breadth first algorithm
    var nodes = Set(root)
    while (nodes.nonEmpty) {
      val haveValue = nodes.filter(_.hasValue)
      haveValue.foreach(n => println(n.prefix, n.parent.map(_.prefix).getOrElse("ROOT")))  //so this is how you would check if it empty Option(None)
//      nodes = (for (node <- nodes) yield {node.children.toSet}).toSet
      var new_nodes = Set.empty[Node]
      for (node <- nodes) {
        new_nodes = new_nodes | node.children.values.toSet
      }
      nodes = new_nodes
    }

  }
}