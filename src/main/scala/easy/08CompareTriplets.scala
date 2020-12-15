package easy

object CompareTriplets08 extends App {
  val alice = Utils.getRandomArray(100, 0, 10000)
  val bob = Utils.getRandomArray(100, 0, 10000)

  val response = compareTriplets(alice, bob)

  println(response.toSeq)

  def compareTriplets(a: Array[Int], b: Array[Int]): Array[Int] = {
    var aliceScore: Int = 0
    var bobScore: Int = 0

    for (i <- 0 to a.length - 1) {
      if (a(i) < b(i)) bobScore += 1
      else if (a(i) > b(i)) aliceScore += 1
    }

//    a.zipWithIndex.foreach(value => {
//      if (value._1 < b(value._2)) bobScore += 1
//      else if (value._1 > b(value._2)) aliceScore += 1
//    })

    Array(aliceScore, bobScore)
  }
}
