package main.scala.extra

import scala.util.control.Breaks.{break, breakable}

object MaximumSubArray extends App {

  val arr = Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)
  val result = maxSubArray(arr)
  println(s"result = $result")

  def maxSubArray(nums: Array[Int]): Int = {
    if (nums.length == 1)
      return nums.head

    var max = nums.head
    for (i <- 1 to nums.size - 1) {
      if (nums(i - 1) > 0) {
        nums(i) += nums(i - 1)
      }

      max = Math.max(max, nums(i))
    }

    max
  }
}
