object UsingTries extends App{
  val myTrie = new MyTrie()
  myTrie.add("Valdis")
  myTrie.add("Voldemars")
  myTrie.add("Liga")

  println(myTrie.contains("Valdis"))
  println(myTrie.contains("October"))
}
