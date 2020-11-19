package easy

object TimeConversion06 extends App {
  def timeConversion(s: String): String = {
    val splits = s.split(":")
    val hour = splits.head
    val mins = splits(1)
    val seconds = splits(2).substring(0,2)
    val period = splits(2).substring(2)

    (period, hour) match {
      case ("AM", "12") => s"${setHour(hour)}:$mins:$seconds"
      case ("AM", _) => s"$hour:$mins:$seconds"
      case ("PM", "12") => s"$hour:$mins:$seconds"
      case ("PM", _) =>  s"${setHour(hour)}:$mins:$seconds"
    }
  }

  def setHour(h: String): String = {
    val hour = h.toInt + 12
    hour match {
      case 24 => "00"
      case _ => hour.toString
    }
  }

  val time = "12:45:54PM"
  val result = timeConversion(time)

  println(s"Converted time is ${result}")
}
