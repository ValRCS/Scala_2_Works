import scala.io.StdIn.readLine

object Anagram extends App {
  val word = readLine("Please input word to test")
  val check_word = readLine("Please enter your guess")

  def showAllAnagrams(word:String) ={
    Seq("")
  }

  def isAnagram(word:String, check_word:String) = false //FIXME


  val anagrams = showAllAnagrams(word)
  println(isAnagram(word, check_word))
  anagrams.foreach(println)
}
