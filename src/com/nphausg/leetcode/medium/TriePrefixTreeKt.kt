package com.nphausg.leetcode.medium

/**
 * <a href="https://leetcode.com/problems/implement-trie-prefix-tree">208. Implement Trie (Prefix Tree)</a>
 */
class TriePrefixTreeKt {

    private val root = TrieNode()

    fun insert(word: String) {
        var current = root
        for (char in word) {
            current = current.children.getOrPut(char) { TrieNode() }
        }
        current.isEndOfWord = true
    }

    fun search(word: String): Boolean {
        var node = root
        for (c in word) {
            if (!node.children.containsKey(c)) {
                return false
            }
            node = node.children[c]!!
        }
        return node.isEndOfWord
    }

    fun startsWith(prefix: String): Boolean {
        var node = root
        for (c in prefix) {
            if (!node.children.containsKey(c)) {
                return false
            }
            node = node.children[c]!!
        }
        return true
    }
}

class TrieNode {
    val children = mutableMapOf<Char, TrieNode>()
    var isEndOfWord = false
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */