package easy

object AppleAndOrange07 extends App {

  // apple tree - home - orange tree

  val apples = Utils.getRandomArray(3, -100, 100)
  val oranges = Utils.getRandomArray(3, -100, 100)
  var samHomeStart, samHomeEnd, applePos, orangePos = 0

  do {
    // Constraints
    // applePos < samHomeStart < samHomeEnd < orangePos
    applePos = Utils.getRandomArray(1, 1, 100).head
    samHomeStart = Utils.getRandomArray(1, 1, 100).head
    samHomeEnd = Utils.getRandomArray(1, 1, 100).head
    orangePos = Utils.getRandomArray(1, 1, 100).head
  } while (applePos >= samHomeStart || samHomeStart >= samHomeEnd || samHomeEnd >= orangePos)

  // print two integers on two different lines
  // 1. first integer = the number of apples that fall on Sam's house
  // 1. second integer = the number of oranges that fall on Sam's house

  countApplesAndOranges(samHomeStart, samHomeEnd, applePos, orangePos, apples, oranges)

  def countApplesAndOranges(samHomeStart: Int, samHomeEnd: Int, applePos: Int, orangePos: Int, apples: Array[Int], oranges: Array[Int]) {
    val applesInHomeSpace = apples
      .map(applePos + _)
      .filter(x => samHomeStart <= x && x <= samHomeEnd)
      .length

    val orangesInHomeSpace = oranges
      .map(applePos + _)
      .filter(x => samHomeStart <= x && x <= samHomeEnd)
      .length

    println(applesInHomeSpace)
    println(orangesInHomeSpace)
  }
}
