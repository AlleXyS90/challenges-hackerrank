package main.scala.extra

object DateDiff01 extends App {
  val birthday = "2019/12/19"
  val currentDay = "2020/12/15"

  // one month have 30 days
  // print age in days
  // without using date time functions

  val birthdaySplits = birthday.split("/").map(_.toInt)
  val currentDaySplits = currentDay.split("/").map(_.toInt)

  var years = currentDaySplits(0) - birthdaySplits(0)
  var months = currentDaySplits(1) - birthdaySplits(1)
  var days = currentDaySplits(2) - birthdaySplits(2)

  if (days < 0) {
    months = months -1
    days = days + 30
  }

  if (months < 0) {
    years = years - 1
    months = months + 12
  }

  val ageInDays = years * 12 * 30 + months * 30 + days

  println(s"years = ${years}, months = ${months}, days = ${days}, age in days = ${ageInDays}")
}
