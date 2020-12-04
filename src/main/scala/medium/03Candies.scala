package medium

object Candies03 extends App {


  val max = 10*10*10*10*10
  val n = Utils.getRandomArray(1, 3, max).head
  val arr = Utils.getRandomArray(n, 1, max)
  // val arr = Array(2, 4, 2, 6, 1, 7, 8, 9, 2, 1)

  val result = candies(n, arr)

  // TODO not done
  println(result)

  def candies(n: Int, arr: Array[Int]): Long = {
    var candiesMap: scala.collection.mutable.Map[Int, Int] = scala.collection.mutable.Map.empty

    for (i <- 0 to n - 1) {
      candiesMap += i -> 1

      // only for first child
      if (i == 0 && arr(i) > arr(i + 1)) {
        candiesMap += i -> 2
      }

      // for next children
      if (i > 0) {
        if (arr(i) > arr(i - 1)) {
          val prevCandies: Int = candiesMap.get(i - 1).getOrElse(1)
          candiesMap += i -> (prevCandies + 1)
        } else if (arr(i) < arr(i - 1)) {
          candiesMap += i -> 1
        }

        // check if is not the last children
        if (i < n - 1 && candiesMap.get(i).getOrElse(1) == 1 && arr(i) > arr(i + 1)) {
          candiesMap += i -> 2
        }
      }

      println(s"i = ${i}, score = ${arr(i)}, candies = ${candiesMap.get(i).getOrElse(1)}")
    }

    candiesMap.map(x => x._2).iterator.sum
  }
}