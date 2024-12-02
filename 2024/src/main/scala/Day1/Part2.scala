package Day1

@main def part2(): Unit =
  val file = scala.io.Source.fromFile("src/main/scala/Day1/test2.txt")
  val lines = try file.mkString finally file.close()

  val allPairs = lines.split("\n").map(pair => pair.split(" {3}"))

  val firstList = allPairs.map(arr => arr.apply(0).toInt)
  val secondList = allPairs.map(arr => arr.apply(1).toInt)
  
  println("hei")