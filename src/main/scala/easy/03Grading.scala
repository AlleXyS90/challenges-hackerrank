package easy

import scala.util.Random

object Grading03 extends App {
    val gradesCount = 4
    val grades = Array.ofDim[Int](gradesCount)

    for (i <- 0 until gradesCount) {
      val gradesItem = Random.nextInt(100)
      grades(i) = gradesItem
    }

    val result = GradingResult.gradingStudents(grades)

  println(s"initial grades")
  grades.toSeq.foreach(println)
  println(s"final grades")
  result.toSeq.foreach(println)
}


object GradingResult {
  def gradingStudents(grades: Array[Int]): Array[Int] = {
    grades.map(x => {
      if (x < 38)
        x
      else
        roundNo(x)
    })
  }

  def roundNo(x: Int): Int = {
    var no = x
    while (no % 5 != 0)
      no += 1

    if (no - x < 3) no else x
  }

}
