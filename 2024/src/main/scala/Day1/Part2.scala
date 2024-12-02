package Day1


@main def main(): Unit =
  val file = scala.io.Source.fromFile("src/main/scala/Day1/input.txt")
  val lines = try file.mkString finally file.close()

  val allPairs = lines.split("\n").map(pair => pair.split(" {3}"))

  val firstList = allPairs.map(arr => arr.apply(0).toInt)
  val mapOfSecondListElementsCount = allPairs.map(arr => arr.apply(1).toInt).groupBy(identity).map(x => (x._1, x._2.length))

  val similarityList = firstList.map(i => mapOfSecondListElementsCount.getOrElse(i, 0) * i)

  println(similarityList.sum())