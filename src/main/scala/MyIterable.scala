case class MyIterable[T](xs: Iterable[T], name:String = "My Iterable") extends Iterable[T] {
  override def iterator = xs.iterator //so this is the only thing required to make your class iterable

  def getInfo() = {
    println(s"I am $name and I hold ${xs.size} items")
  }

}