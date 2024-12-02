package Day1

@main def main(): Unit =
  val file = scala.io.Source.fromFile("src/main/scala/Day1/input.txt")
  val lines = try file.mkString finally file.close()

  val allPairs = lines.split("\n").map(pair => pair.split(" {3}"))

  val firstList = allPairs.map(arr => arr.apply(0).toInt).sorted()
  val secondList = allPairs.map(arr => arr.apply(1).toInt).sorted()

  val totalDifference = firstList.zip(secondList).map((a, b) => (a - b).abs).sum()

  println(totalDifference)
