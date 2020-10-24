object TestingIterable extends App {
  val a = MyIterable(Vector(1,2,3))
  val b = a.map(_+1) // res0: Iterable[Int] = List(2, 3, 4)
  val c = a.filter(_%2==1) // res1: Iterable[Int] = List(1, 3)
  a.foreach(println)
  b.foreach(println)
  c.foreach(println)
  a.getInfo()
  val d = MyIterable(c, name= "My filtered Iterable")
  d.getInfo()
  println(d)

}
