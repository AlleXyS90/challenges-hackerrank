package medium

import scala.collection.mutable.ListBuffer
import scala.util.Random

object ClimbingTheLeaderboard01 extends App {
  // val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

  //  val rankedCount = StdIn.readLine.trim.toInt
  //  val ranked = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
  //  val playerCount = StdIn.readLine.trim.toInt
  //  val player = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

  val ranked = Array(100, 90, 90, 80, 75, 60)
  for (_ <- 1 to 200000) {
    generatedBoardScoring += Random.nextInt(999999999)
  }
  val player = Array(50, 65, 77, 90, 102)
  for (_ <- 1 to 10000) {
    generatedPlayerScoring += Random.nextInt(1999999999)
  }
  val result = Result.climbingLeaderboard(generatedBoardScoring.toArray, generatedPlayerScoring.toArray)
  var generatedBoardScoring: ListBuffer[Int] = ListBuffer.empty
  // val result = Result.climbingLeaderboard(ranked, player)
  var generatedPlayerScoring: ListBuffer[Int] = ListBuffer.empty

  result.toList.map(println)
}

object Result {

  /*
   * Complete the 'climbingLeaderboard' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY ranked
   *  2. INTEGER_ARRAY player
   */

  def climbingLeaderboard(ranked: Array[Int], player: Array[Int]): Array[Int] = {
    val start = System.currentTimeMillis / 1000
    println("transform to map. start = 0")

    println(s"before foreach. time = ${System.currentTimeMillis / 1000 - start}")
    var counter = 0

    import scala.collection.parallel.CollectionConverters._
    val posInParallel: Array[Int] = player.zipWithIndex.par.map(score => {
      val playersWithHiggerScore = ranked.distinct
        .filter(x => x > score._1).length

      if (playersWithHiggerScore != 0)
        playersWithHiggerScore + 1
      else 1

      //  score._1
    }).toArray

    //    val positions: Array[Int] = player.map(score => {
    //      val playersWithHiggerScore = ranked.distinct
    //        .filter(x => x > score).length
    //
    //            counter += 1
    //            if (counter % 100 == 0) println(s"counter = ${counter}. timer = ${System.currentTimeMillis / 1000 - start}")
    //
    //        if (playersWithHiggerScore != 0)
    //          playersWithHiggerScore + 1
    //        else 1
    //    })
    //    println(s"before printing. time = ${System.currentTimeMillis / 1000 - start}")

    posInParallel
  }

}
