package Day3

import scala.util.matching.Regex

val pattern: Regex = """mul\([0-9]+,[0-9]+\)""".r

@main def main(): Unit =
  val file = scala.io.Source.fromFile("src/main/scala/Day3/input.txt")
  val lines = try file.mkString.split("\n") finally file.close()

  val mulLines = lines.map(line =>
    pattern.findAllMatchIn(line).map(m => m.matched.split("\\D+").filter(_.nonEmpty).map(_.toInt).product).sum
  ).sum


  println("hei: " + mulLines)