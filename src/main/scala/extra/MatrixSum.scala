package main.scala.extra

object MatrixSum extends App {
  val a = Array(
    Array(1,1,1,1),
    Array(2,2,2,2),
    Array(3,3,3,3)
  )
  val b = Array(
    Array(5,5,5),
    Array(5,5,5),
    Array(7,7,7)
  )

  val result = sum(a, b)

  result.foreach(row => println(row.toSeq.toString()))


  def sum(a: Array[Array[Int]], b: Array[Array[Int]]): Array[Array[Int]] = {
    var rows = a.length
    if (b.length > rows)
      rows = b.length

    var cols = a.head.length
    if (b.head.length > cols)
      cols = b.head.length

    val results: Array[Array[Int]] = Array.ofDim[Int](rows, cols)

    for (i <- 0 to rows - 1) {
      val cols = a.head.length
      val row: Array[Int] = Array.ofDim[Int](cols)
      for (j <- 0 to cols - 1)
        row(j) = value(a, i, j) + value(b, i, j)

      results(i) = row
    }

    results
  }

  private def value(a: Array[Array[Int]], x: Int, y: Int): Int =
    if (a.length <= x || a.head.length <= y) 0
    else a(x)(y)
}
