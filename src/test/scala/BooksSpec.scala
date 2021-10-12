import Books._

class BooksSpec extends munit.FunSuite {

  test("stockSummary should return \"\" when lstOfArt == Array.empty || lstOfCat == Array.empty") {
    assertEquals(stockSummary(Array.empty, Array("A")), "")
    assertEquals(stockSummary(Array("A"), Array.empty), "")
  }

  test("makeMap should return a Map with the first letters as the key and the numbers as the value") {
    val lstOfArt = Array("BBAR 150", "CDXE 515")
    assertEquals(makeMap(lstOfArt), Map("B" -> 150, "C" -> 515))
  }

  test("makeMap should return a Map with the first letters as the key and the numbers as the value, and add the values together if there are 2 indexes with the same first letter") {
    val lstOfArt = Array("BBAR 150", "CDXE 515", "BHH 280")
    assertEquals(makeMap(lstOfArt), Map("B" -> 430, "C" -> 515))
  }



  test("selectCatFromArt returns a Map with only the letters from the lstOfCat, and 0 if that letter is not in lstOfArt") {
    val mapOfArt = Map("B" ->150, "C" -> 515)
    val lstOfCat = Array("A", "B")
    assertEquals(selectCatFromArt(mapOfArt, lstOfCat), Map("A" -> 0, "B" -> 150))
  }


}
