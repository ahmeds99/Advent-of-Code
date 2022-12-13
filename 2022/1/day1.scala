import scala.io.Source._
import scala.collection.mutable.ListBuffer

@main def main() =
    val source = fromFile("input.txt")
    val lines = try source.mkString finally source.close()

    var maks = 0
    var groupSums = new ListBuffer[Int]()
    var groupSum: Int = 0
    for (line <- lines.split("\n")) {
        if (line.strip().equals("")) 
            maks = maks.max(groupSum)
            groupSums += groupSum
            groupSum = 0
        else 
            groupSum += line.strip().toInt
    }
    maks = maks.max(groupSum)
    groupSums += groupSum

    println(groupSums.sortWith(_ > _).slice(0, 3).sum)