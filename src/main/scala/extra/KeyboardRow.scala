package main.scala.extra

import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks.{break, breakable}

object KeyboardRow extends App {

  val first = "qwertyuiop"
  val second = "asdfghjkl"
  val third = "zxcvbnm"

  val input = List("Alaska", "Hello", "Dad", "Peace")

  val results = findWords(input)

  println(s"results = ${results.toString}")


  def findWords(input: List[String]): Array[String] = {
    val words: ListBuffer[String] = ListBuffer.empty

    input.foreach(word => {
      var sameType = true
      val firstC = word.charAt(0).toLower
      val row = getType(firstC)

      breakable {
        word.tail.toLowerCase.foreach(c => {
          val cRow = getType(c)
          if (cRow != row) {
            sameType = false
            break
          }
        })
      }

      if (sameType)
        words += word
    })

    words.toArray
  }

  def getType(c: Char): Int = {
    if (first.contains(c)) 1
    else if (second.contains(c)) 2
    else 3
  }
}
