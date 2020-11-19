package easy

object MinMaxSum04 extends App {
  val array = Utils.getRandomArray(5, 0, 50)

  def miniMaxSum(arr: Array[Int]) = {
    val valid = arr.forall(x => x >= 1 && x <= scala.math.pow(x, 9))
    if (!valid)
      throw new Exception("Invalid numbers")

    val sorted = arr.sortBy(x => x).map(x => BigDecimal(x))
    val min = sorted.take(4).sum
    val max = sorted.tail.sum

    println(min + " " + max)
  }

  miniMaxSum(array)
}
