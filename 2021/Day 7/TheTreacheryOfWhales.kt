import java.io.File
import java.nio.file.Paths
import kotlin.math.abs

fun main() {
    var liste = readFile("input.txt")
    liste = mergeSort(liste)

    println(calculateFuel(findMedian(liste),liste))
    println(findLowestFuel(liste))
}

fun findLowestFuel(liste: IntArray): Int {
    var lowestFuel = Int.MAX_VALUE
    for (i in liste[0] until liste[liste.size - 1]) {
        val posFuel = calculateNewFuel(i, liste)
        if (posFuel < lowestFuel) lowestFuel = posFuel
    }
    return lowestFuel
}

fun calculateNewFuel(check: Int, liste: IntArray): Int {
    var totalFuel = 0
    for (num in liste) {
        val distance = abs(check - num)
        totalFuel += (distance * (distance + 1)) / 2
    }
    return totalFuel
}
/*
fun fuelCost(distance: Int): Int {
    if (distance == 1) return 1
    return distance + fuelCost(distance - 1)
}
*/

fun calculateFuel(median: Int, liste: IntArray): Int {
    var totalFuel = 0
    for (num in liste) totalFuel += abs(median - num)
    return totalFuel
}

fun findMedian(liste: IntArray): Int {
    val mid = liste.size / 2
    // returner medianen
    return if (liste.size % 2 == 0) (liste[mid] + liste[mid - 1]) / 2 else liste[mid]
}

fun mergeSort(A: IntArray): IntArray {
    if (A.size <= 1) return A
    val i = A.size / 2
    val A1 = mergeSort(A.copyOfRange(0, i))
    val A2 = mergeSort(A.copyOfRange(i, A.size))
    return merge(A1, A2)
}

fun merge(A1: IntArray, A2: IntArray): IntArray {
    var i = 0
    var j = 0
    val resultat = IntArray(A1.size + A2.size)

    while (i < A1.size && j < A2.size) {
        if (A1[i] <= A2[j]) resultat[i + j] = A1[i++]
        else resultat[i + j] = A2[j++]
    }

    while (i < A1.size) resultat[i + j] = A1[i++]
    while (j < A2.size) resultat[i + j] = A2[j++]
    return resultat
}

fun readFile(fileName: String): IntArray {
    val path = Paths.get("").toAbsolutePath().toString()
    val info = File("$path/Kotlin/src/$fileName").bufferedReader().readLine().split(",")
    val liste = IntArray(info.size)
    for (i in info.indices) liste[i] = info[i].toInt()
    return liste
}
