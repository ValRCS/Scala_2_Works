import PatternMatch.printIndex
// https://alvinalexander.com/scala/how-to-rename-members-import-scala-classes-methods-functions/
import PatternMatch.{printDay => pD}

object UsingPatternMatch extends App {

  PatternMatch.printDay(4)
  PatternMatch.printDay(70)
  pD(6) // these kind of short names should be used when there is no confusion on their meaning

  PatternMatch.printIndex("Saturday")
  PatternMatch.printIndex("Sat")
  printIndex("Sat")

}
