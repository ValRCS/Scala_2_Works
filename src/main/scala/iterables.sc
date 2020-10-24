val a = new MyIterable(Vector(1,2,3))
a.map(_+1) // res0: Iterable[Int] = List(2, 3, 4)
a.filter(_%2==1) // res1: Iterable[Int] = List(1, 3)