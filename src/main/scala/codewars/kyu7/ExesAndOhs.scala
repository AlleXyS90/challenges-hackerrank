package main.scala.codewars.kyu7

object ExesAndOhs extends App {
  //  Check to see if a string has the same amount of 'x's and 'o's.
  //  The method must return a boolean and be case insensitive.
  //  The string can contain any char.

  val result = xo("ooXxXXs")

  println(s"result is $result")

  def xo(value: String): Boolean = {
    val grouped = value.toList
      .filter(a => List('x', 'o')
        .contains(a.toLower))
      .groupBy(_.toLower.charValue())

    grouped.get('x').getOrElse(List.empty).length ==
      grouped.get('o').getOrElse(List.empty).length
  }
}
