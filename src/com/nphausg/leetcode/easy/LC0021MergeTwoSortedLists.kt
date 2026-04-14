package com.nphausg.leetcode.easy

/**
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists">21. Merge Two Sorted Lists</a>
 */
class LC0021MergeTwoSortedLists {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) return l2
        if (l2 == null) return l1
        if( l1.`val` < l2.`val`){
            l1.next = mergeTwoLists(l1.next, l2)
            return l1
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next)
            return l2
        }
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
