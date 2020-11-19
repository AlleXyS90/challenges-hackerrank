package  medium

object MagicSquareForming02 extends App {
  val size = 3
  val s: Array[Array[Int]] = Array.ofDim[Int](size, size)

  for (i <- 0 to 2) {
    var arr = Array.emptyIntArray
    while (arr.toSeq.distinct.length != size) {
      // get distinct values for each row
      arr = Utils.getRandomArray(3, 1, 9)
    }
    s(i) = arr
  }

  def formingMagicSquare(s: Array[Array[Int]]): Int = {
    // TODO - unsolved
    // array size is N x N
    // sum of each row, column or diagonal must be 15
    // rows 0, 1, 2
    // cols 0, 1, 2
    // diag 0, 1
    for (i <- 0 to s.length - 1) {
      for (j <- 0 to s.length - 1) {
        val row = s(i)
        val sumOfRow = s(i).sum
        if (sumOfRow != 15)
          println(s"diff = ${15 - sumOfRow}")

      }
    }

    s.foreach(row => {
      row.foreach(cell => {

      })
    })
    s.foreach(x => {
      val arr = x.mkString(",")
      println(arr)
    })

    22
  }



  val result = formingMagicSquare(s)
  println("result is ")
  println(result)
}
