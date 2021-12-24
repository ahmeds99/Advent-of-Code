import java.io.File
import java.nio.file.Paths

fun main() {
    val liste = ArrayList<Int>()
    val path = Paths.get("").toAbsolutePath().toString()
    val info = File("$path/Kotlin/src/input.txt").bufferedReader().readLine().split(",")
    for (num in info) liste.add(num.toInt())

    val fishList = LongArray(9)

    for (tall in liste) fishList[tall]++

    for (i in 0 until 256) {
        val rebirth = fishList[0]
        for (j in 1..8) fishList[j - 1] = fishList[j]
        fishList[8] = rebirth
        fishList[6] += rebirth
    }
    println(fishList.sum())

    /*
    Here is the naive method, which works on the first part, but way too slow for the second part.
    println("Inital state: $liste")
    for (i in 0 until 256) {
        var antSkalLeggesTil = 0
        for (j in 0 until liste.size) {
            if (liste[j] == 0) {
                antSkalLeggesTil++
                liste[j] = 6
            } else liste[j]--
        }
        for (k in 0 until antSkalLeggesTil) liste.add(8)
        //println("After day ${i + 1}: $liste")
    }
    */
}