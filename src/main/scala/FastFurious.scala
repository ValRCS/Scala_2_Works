object FastFurious extends App{
  println("The movie was \"Fast and Furious\" \t \n\tthe first movie was not too bad \\ so backslash also needed escaping")
  val big_string =
    """
      |Big long string
      |With many lines
      |And any "quotes" or 'single quotes' inside are fine too
      |""".stripMargin
  println(big_string)
}
