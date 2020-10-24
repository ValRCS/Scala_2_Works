object UsingCaseClass extends App {
  val p = Point(5,10) //we create instances from our Point case class
  val p2 = Point(5,10)
  val p3 = Point(50,90)
  val p4 = p.copy(y = 200) //comes from using case class
  println(p.x, p.y)
  println(p == p2, p == p3) //so case class gives us ability to compare contents between instances
  println(p, p4)
  println(p.z, p.zz)
  println(p.distance)

}
