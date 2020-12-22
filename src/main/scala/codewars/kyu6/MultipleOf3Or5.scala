package main.scala.codewars.kyu6

object MultipleOf3Or5 extends App {

  //  If we list all the natural numbers below 10 that are multiples of 3 or 5,
  //  we get 3, 5, 6 and 9. The sum of these multiples is 23.

  //  Finish the solution so that it returns the sum of all
  //  the multiples of 3 or 5 below the number passed in.

  //  Note: If the number is a multiple of both 3 and 5, only count it once.
  //  Also, if a number is negative, return 0(for languages that do have them)

  val number = Utils.getRandomArray(1, 1, 1000).head
  val result = solution(number)

  println(s"result is ${result}")

  def solution(number: Int): Long = {
    (1 to number - 1).iterator
      .filter(x => x % 3 == 0 || x % 5 == 0)
      .map(_.toLong)
      .sum
  }
}
