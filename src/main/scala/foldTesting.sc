val numArray = Array(12, 6, 15, 2, 20, 9)

numArray.reduceLeft(_ + _)
numArray.reduceLeft((x, y) => x max y)

//both the above the same as
numArray.sum

val findMax = (x: Int, y: Int) => {
  val winner = x max y

  winner
}

numArray.reduceLeft(findMax)