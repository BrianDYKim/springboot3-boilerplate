package team.me.common.utils

import kotlin.random.Random

fun <T> List<T>.shuffleList(): List<T> {
    val shuffledList = this.toMutableList()
    val random = Random(System.currentTimeMillis())

    for (i in shuffledList.indices) {
        val randomIndex = random.nextInt(i, shuffledList.size)
        val temp = shuffledList[i]
        shuffledList[i] = shuffledList[randomIndex]
        shuffledList[randomIndex] = temp
    }

    return shuffledList
}
