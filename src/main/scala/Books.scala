object Books extends App {

  val lstOfArt: Array[String] = Array("BBAR 150", "CDXE 515", "BKWR 250", "BTSQ 890", "DRTY 600",  "ABAR 200", "CDXEF 500", "BKWRW 250", "BTSQA 890", "DRTYU 600",
    "CBART 20", "CDXEG 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60", "ROXANNE 102", "RHODODE 123", "BKWRKAA 125", "BTSQZFG 239", "DRTYMKH 060",
    "ROXANNEB 102", "RHODODEA 123", "BKWRKAB 125", "BTSQZA 239", "DRTYMKA 060",  "ROXANNEA 102", "RHODODEB 123", "BKWRKAC 125", "BTSQZB 239", "DRTYMKB 060",
    "ROXANNEC 102", "RHODODEC 123", "BKWRKAD 125", "BTSQZC 239", "DRTYMC 060", "RHIB 1230", "RO 530", "XILO 32",
    "ROXANNEZ 102", "RHODODED 123", "BKWRKAE 125", "BTSQZD 239", "DRTYMD 060", "RHIBA 1230", "ROA 530", "XILOA 32",
    "UZO 32000", "ROXANNES 102", "RHODODEF 123", "BKWRKAF 125", "BTSQZE 239", "DRTYME 060", "RHIBB 1230", "ROB 530", "XILOB 32")
  val lstOfCat: Array[String] = Array("A",  "B",  "C",  "F",  "D",  "R",  "U",  "X",  "W")

  def stockSummary(lstOfArt: (Array[String]), lstOfCat: Array[String]): String = {
    if (lstOfArt.isEmpty || lstOfCat.isEmpty) ""
    else {
      val madeMap = makeMap(lstOfArt)
      val selectedCats = selectCatFromArt(madeMap, lstOfCat)
      makeResString(selectedCats, lstOfCat, "")dropRight(3)
    }
  }

  def makeMap(lstOfArt: Array[String]): Map[String, Int] = {
    lstOfArt.foldLeft(Map[String,Int]()) {
      (m,s) => m + (s.head.toString -> (
        if(m.contains(s.head.toString))
          m(s.head.toString) + s.filter(_.isDigit).toInt
        else
          s.filter(_.isDigit).toInt)
        )
    }
  }

  def selectCatFromArt(mapOfArt: Map[String, Int], lstOfCat: Array[String]): Map[String, Int] = {
    lstOfCat.foldLeft(Map[String,Int]()) { (m,s) => m + (s -> (
      if (mapOfArt.contains(s))
        mapOfArt(s)
      else
        0)
      )
    }
  }

  def makeResString(map: Map[String, Int], lsCat: Array[String], st: String): String = {
    lsCat.map(x => st + s"(${x} : ${map(x)}) - ").mkString
  }

  println(stockSummary(lstOfArt, lstOfCat))

}

