package main.scala.codewars.kyu8

object Series2Clock extends App {
  // Clock shows 'h' hours, 'm' minutes and 's' seconds after midnight.
  // Your task is to make 'Past' function which returns time converted to milliseconds.
  // past(0, 1, 1) == 61000

  val result = past(0, 1, 1)
  println(s"result is $result")

  def past(h: Int, m: Int, s: Int): Int = (h * 3_600 + m * 60 + s) * 1_000
}
