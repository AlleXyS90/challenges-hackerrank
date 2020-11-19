package easy

object ArrayOfNElements01 extends App {
  def f(num:Int) : List[Int] = {
    if (num < 1 || num > 100)
      throw new Exception(s"Value ${num} is outside the range [0, 100]")

    List.range(0, num)
  }

  val num = Utils.getRandomArray(1, 0, 110).head
  println(f(num))
}
