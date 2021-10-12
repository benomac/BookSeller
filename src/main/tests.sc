val lstOfCat: Array[String] = Array("A",  "B",  "C",  "F",  "D",  "R",  "U",  "X",  "W")
val map = Map("A" -> 150, "B" -> 200)

def selectCatFromArt(mapOfArt: Map[String, Int], lstOfCat: Array[String], acc: Map[String, Int]): Map[String, Int] = {
      if (lstOfCat.isEmpty) acc
      else
        if (mapOfArt.contains(lstOfCat.head)) selectCatFromArt(mapOfArt, lstOfCat.tail, acc + (lstOfCat.head -> mapOfArt(lstOfCat.head)))
        else
          selectCatFromArt(mapOfArt, lstOfCat.tail, acc + (lstOfCat.head -> 0))
}
selectCatFromArt(map, lstOfCat, Map.empty).toString

lstOfCat.foldLeft(Map[String,Int]()) { (m,s) => m + (s -> (if (map.contains(s)) map(s) else 0)) }
