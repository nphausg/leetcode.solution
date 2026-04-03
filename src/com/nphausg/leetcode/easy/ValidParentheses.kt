package com.nphausg.leetcode.easy

import java.util.ArrayDeque

/**
 * <a href="https://leetcode.com/problems/valid-parentheses">20. Valid Parentheses</a>
 */
class ValidParenthesesKt {

    fun isValid(s: String): Boolean {
        if (s.length % 2 == 1) {
            return false
        }

        val stack = ArrayDeque<Char>()
        for (char in s) {
            when (char) {
                '(' -> stack.addLast(')')
                '{' -> stack.addLast('}')
                '[' -> stack.addLast(']')
                else -> if (stack.isEmpty() || stack.removeLast() != char) {
                    return false
                }
            }
        }

        return stack.isEmpty()
    }

    fun isValidMapBased(s: String): Boolean {
        if (s.length % 2 == 1) {
            return false
        }

        val pairs = mapOf(')' to '(', '}' to '{', ']' to '[')
        val stack = ArrayDeque<Char>()

        for (char in s) {
            if (char in pairs.values) {
                stack.addLast(char)
            } else {
                if (stack.isEmpty() || stack.removeLast() != pairs[char]) {
                    return false
                }
            }
        }

        return stack.isEmpty()
    }
}
