import scala.io.Source._

// X loss, Y draw and Z win
@main def day2() = 
    val source = fromFile("input.txt")
    val lines = try source.mkString finally source.close()    
    
    val shapePoint = Map("A" -> 1, "B" -> 2, "C" -> 3)
    val scores = Map("X" -> "rock", "A" -> "rock",
                     "Y" -> "paper", "B" -> "paper",
                     "Z" -> "scissor", "C" -> "scissor")
    var mySum: Int = 0
    for (line <- lines.split("\n")) {
        val info = line.strip().split(" ")
        if (info(1).equals("Y"))
            mySum += shapePoint.getOrElse(info(0), 0) + 3
        else 
            val result = decideGame(scores.getOrElse(info(0), ""), info(1))
            mySum += result
    }
    println(mySum)

def decideGame(opponent: String, me: String): Int =
    return opponent match {
        case "rock" => if (me.equals("X")) 3 else (2 + 6)
        case "paper" => if (me.equals("X")) 1 else (3 + 6)
        case "scissor" => if (me.equals("X")) 2 else (1 + 6)
    }
