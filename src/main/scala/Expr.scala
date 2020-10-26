  sealed trait Expr {
    val myType = "Expression"
    def printType() = println(myType)
  }
  case class BinOp(left: Expr, op: String, right: Expr) extends Expr {
    override val myType = "BinOp"
  }
  case class Literal(value: Int) extends Expr {
    override val myType = "Literal"
  }
  case class Variable(name: String) extends Expr {
    override val myType = "Variable"
  }

//so again we use this when we have a constant number of classes(or case classes)
  //those classes can use something fromt the trait

//  def stringify(expr: Expr): String = expr match {
//    case BinOp(left, op, right) => s"(${stringify(left)} $op ${stringify(right)})"
//    case Literal(value) => value.toString
//    case Variable(name) => name
//  }

//  val smallExpr = BinOp(
//    Variable("x"),
//    "+",
//    Literal(1)
//  )

