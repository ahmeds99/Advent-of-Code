package Day2

def day2(): Unit =
  val file = scala.io.Source.fromFile("src/main/scala/Day2/input.txt")
  val lines = try file.mkString finally file.close()

  val allLines = lines.split("\n").map(line => line.split(" ").map(numStr => numStr.toInt))

  val result = allLines.filter(report => {
    val increasing = report(0) <= report(1)

    report.sliding(2).filter(list =>
      checkIfSorted(increasing, list(0), list(1)) && validDifference(list(0), list(1))
    ).toList.length == report.length - 1
  })

  println(result.length)


def checkIfSorted(increasing: Boolean, num1: Int, num2: Int): Boolean =
  if (increasing) num1 <= num2 else num1 >= num2

def validDifference(num1: Int, num2: Int): Boolean = (num1 - num2).abs >= 1 && (num1 - num2).abs <= 3
