package easy

object ReverseList02 extends App {

  import scala.collection.mutable.ListBuffer

  val array = Utils.getRandomArray(1000, 0, 100)

  def f(arr: List[Int]): List[Int] = {
    var reversed: ListBuffer[Int] = ListBuffer.empty
    for (i <- arr.length - 1 to 0 by -1) {
      reversed += arr(i)
    }

    //    val reversedList = arr.zipWithIndex.map(t => arr(arr.length - t._2 - 1))

    // test for 100k values
    // for is 5th times faster than arr.zipWithIndex

    reversed.toList
  }

  println(f(array.toList))
}
