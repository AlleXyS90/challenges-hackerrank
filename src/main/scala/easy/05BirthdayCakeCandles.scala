package easy

object BirthdayCakeCandles05 extends App {
  def birthdayCakeCandles(candles: Array[Int]): Int = {
    val sorted = candles.sortBy(x => x).reverse
    val count = sorted.filter(x => x == sorted.head).length

    count
  }

  val arr = Utils.getRandomArray(4, 0, 5)
  val result = birthdayCakeCandles(arr)
  println(s"The max candles are repeated $result times")
}
