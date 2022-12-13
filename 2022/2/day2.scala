import scala.io.Source._

@main def day2() = 
    val source = fromFile("input.txt")
    val lines = try source.mkString finally source.close()    
    
    val shapePoint = Map("X" -> 1, "Y" -> 2, "Z" -> 3)
    val scores = Map("X" -> "rock", "A" -> "rock",
                     "Y" -> "paper", "B" -> "paper",
                     "Z" -> "scissor", "C" -> "scissor")
    var mySum: Int = 0
    for (line <- lines.split("\n")) {
        val info = line.strip().split(" ")
        val result = decideGame(scores.getOrElse(info(0), ""), scores.getOrElse(info(1), ""))
        mySum += shapePoint.getOrElse(info(1), 0) + result
    }
    println(mySum)

def decideGame(opponent: String, me: String): Int =
    if (opponent.equals(me)) return 3

    return opponent match {
        case "rock" => if (me.equals("paper")) 6 else 0
        case "paper" => if (me.equals("scissor")) 6 else 0
        case "scissor" => if (me.equals("rock")) 6 else 0
    }
