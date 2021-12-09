/*
 * Created by nphau on 09/12/2021, 00:30
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 09/12/2021, 15:54
 */
fun solution(numbers: IntArray): Int {
        val n = numbers.size
        val present = BooleanArray(n + 1)
        numbers.forEach { number ->
            if (number in 1..n) {
                present[number] = true
            }
        }
        for (index in 1..n) {
            if (!present[index])
                return index
        }
        return n + 1
}