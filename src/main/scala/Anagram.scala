import scala.io.StdIn.readLine

object Anagram extends App {
  val word = readLine("Please input word to test")
  val check_word = readLine("Please enter your guess")

  def showAllAnagrams(word:String) ={
    word.toSeq.permutations.map(_.mkString("")).toSeq
  }

  def isAnagram(word:String, checkWord:String) = word.toSeq.sorted.unwrap == checkWord.toSeq.sorted.unwrap


  val anagrams = showAllAnagrams(word)
  println(isAnagram(word, check_word))
  anagrams.foreach(println)
}
