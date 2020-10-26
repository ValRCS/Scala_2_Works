object Using_Expr extends App {
  println(555) // so 555 is a literal
  println("Valdis") //so Valdis in a string is a string literal
  val num = Literal(555)
  val myVar = Variable("x")
  val smallExpr = BinOp(
    Variable("x"),
    "+",
    Literal(1)
  )

  def stringify(expr: Expr): String = expr match {
    case BinOp(left, op, right) => s"(${stringify(left)} $op ${stringify(right)})" // recursive call to stringify
    case Literal(value) => value.toString
    case Variable(name) => name
  }

  def evaluate(expr: Expr, values: Map[String, Int]): Int = expr match {
    case BinOp(left, "+", right) => evaluate(left, values) + evaluate(right, values)
    case BinOp(left, "-", right) => evaluate(left, values) - evaluate(right, values)
    case BinOp(left, "*", right) => evaluate(left, values) * evaluate(right, values)
    case Literal(value) => value
    case Variable(name) => values(name)
      //so to cover badly formed expression i'd rather throw an exception to have an error
    case _ => throw new IllegalArgumentException("Bad Operation")//not the best handle for errors because we might need -99999
  }

  println(stringify(num))
  println(stringify(myVar))
  println(stringify(smallExpr))

  val largeExpr = BinOp(
    BinOp(Variable("x"), "+", Literal(1)),
    "*",
    BinOp(Variable("y"), "-", Literal(1))
  )

  val badExpr = BinOp(
    BinOp(Variable("x"), "+", Literal(1)),
    "/",
    BinOp(Variable("y"), "-", Literal(1))
  )

  println(largeExpr)
  num.printType()
  myVar.printType()
  println(evaluate(smallExpr, Map("x" -> 50)))
  println(evaluate(largeExpr, Map("x" -> 50, "y" -> 10)))
  println(evaluate(badExpr, Map("x" -> 50, "y" -> 10)))

}
