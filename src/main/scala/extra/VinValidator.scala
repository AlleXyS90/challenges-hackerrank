package main.scala.extra

object VinValidator extends App {
  val maps = Map(
    1 -> "AJ",
    2 -> "BKS",
    3 -> "CLT",
    4 -> "DMU",
    5 -> "ENV",
    6 -> "FW",
    7 -> "GPX",
    8 -> "HY",
    9 -> "RZ"
  )
  val weights = List(8, 7, 6, 5, 4, 3, 2, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2)

  val vin = "1M8GDM9A_KP042788"
  var formattedVin = getFormatedVin(vin)
  println(s"vin = ${formattedVin}")
  val productsRow = getProductsRow(formattedVin)
  println(s"products = ${productsRow}")

  def getFormatedVin(vin: String): String = {
    vin.toUpperCase.map(char => {
      if (Character.isDigit(char) || char == '_')
        char
      else {
        val exists = maps.find(x => x._2.contains(char))
        exists match {
          case Some(mapper) => mapper._1.toString
          case None => throw new Exception(s"INVALID VIN. LETTER $char is not valid")
        }
      }
    }).mkString("")
  }

  def getProductsRow(vin: String): List[Int] = {
    // AICI CALCULEZI PRODUCTS ROW
    vin.zipWithIndex.map(value => {
      val digit = value._1
      val index = value._2
      val weight = weights(index)
      print(digit + ",")
      digit.toInt
    }).toList
  }

}
