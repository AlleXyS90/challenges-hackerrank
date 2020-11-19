package scala

import scala.collection.mutable.ListBuffer
import scala.util.Random

object Utils {
  def getRandomArray(length: Int, min: Int, max: Int): Array[Int] = {
    var arr: ListBuffer[Int] = ListBuffer.empty
    for (_ <- 1 to length) {
      arr += Random.nextInt(max) + min
    }
    arr.toArray
  }
}
