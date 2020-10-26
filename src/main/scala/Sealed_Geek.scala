sealed trait Geeks
{
  val article="not done"
}
// Class extends trait
class Scala extends Geeks
{
  override val article = "scala article"
}

// Class extends trait
class Java extends Geeks
{
  override val article = "java article"
}

// Class extends trait
class Csharp extends Geeks
{
  override val article = "csharp article"
}