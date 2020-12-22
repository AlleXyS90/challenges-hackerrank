package main.scala.extra

import scala.collection.mutable.ListBuffer

object PrimeNumbers02 extends App {
  val value = Utils.getRandomArray(1, 3, 100).head

  val result = PrimeNumberResult.isPrime(value)
  println(s"Prime result for number ${value}: ${result}")

  val decomposition = PrimeNumberResult.decompositionIntoPrimeFactors(value)
  println(s"Decomposition result for number ${value} = ${decomposition}")
}

object PrimeNumberResult {
  def decompositionIntoPrimeFactors(value: Int): String = {
    var numbers: Map[Int, Int] = Map.empty

    if (isPrime(value))
      return s"$value^1"

    var no = value
    var divisor = 2

    while (no > 1) {
      var power = 0
      while (no % divisor == 0) {
        power += 1
        no = no / divisor
      }

      if (power > 0)
        numbers += divisor -> power

      divisor += 1
    }

    numbers
      .map(x => s"${x._1}^${x._2}")
      .mkString(" * ")
  }

  implicit def ++(value: Int) = value + 1

  def isPrime(value: Int): Boolean = {
    var isPrime = true

    if (value == 1)
      return isPrime

    (2 until value).iterator
      .takeWhile(_ => isPrime)
      .foreach(i => if (value % i == 0) isPrime = false)

    isPrime
  }
}