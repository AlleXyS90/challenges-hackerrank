package easy

object Staircase09 extends App {
  val value = Utils.getRandomArray(1, 3, 10).head

  staircase(value)

  def staircase(n: Int) = {
    var minPos = n
    for (_ <- 1 to n) {
      val emptyFields = List.fill(minPos - 1)(" ")
      val sharpFields = List.fill(n - minPos + 1)("#")
      println(emptyFields.concat(sharpFields).mkString(""))

      minPos -= 1
    }
  }
}