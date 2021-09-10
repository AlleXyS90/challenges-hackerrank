package main.scala.extra

object SumOfArrayDigits extends App {
  val x = List(2,1,7,8)
  val y = List(5, 9, 6)

  val result = sum(x, y)
  println(s"result = ${result.toString}")

  def sum(x: List[Int], y: List[Int]): List[Int] = {
    var result: List[Int] = List.empty

    var maxCount = x.length
    if (y.length > maxCount)
      maxCount = y.length

    var rest = 0
    var remove = 1
    while (maxCount > 0) {
      val fromX = x.length - remove >= 0 match {
        case true => x(x.length - remove)
        case false => 0
      }
      val fromY = y.length - remove >= 0 match {
        case true => y(y.length - remove)
        case false => 0
      }

      var digit = rest + fromX + fromY

      if (digit > 9) {
        digit -= 10
        rest = 1
      } else rest = 0

      result = digit :: result
      remove += 1
      maxCount -= 1
    }

    if (rest == 1)
      result = 1 :: result

    result
  }
}
