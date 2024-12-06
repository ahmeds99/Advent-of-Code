package Day2

@main def main(): Unit =
  val file = scala.io.Source.fromFile("src/main/scala/Day2/input.txt")
  val lines = try file.mkString finally file.close()

  val allLines = lines.split("\n").map(line => line.split(" ").map(numStr => numStr.toInt))

  val result = allLines.filter(report => {
    val increasing = if (!validDifference(report(0), report(1))) report(0) <= report(1) else report(0) <= report(2)
    var i = 0
    var valid = false
    while (i < report.length) {
      if (!valid) valid = isValid(report.patch(i, Nil, 1))

      i += 1
    }
    valid
  })

  println(result.length)


def isValid(list: Array[Int]): Boolean =
  val increasing = if (!validDifference(list(0), list(1))) list(0) <= list(1) else list(0) <= list(2)
  list.sliding(2).filter(list =>
    checkIfSorted(increasing, list(0), list(1)) && validDifference(list(0), list(1))
  ).toList.length == list.length - 1