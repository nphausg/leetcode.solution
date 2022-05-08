/**
 * Created by nphau on 09/12/2021, 00:30
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 09/12/2021, 15:54
 */
package sg.nphau.leetcode.easy;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses
 */
public class ValidParentheses {
    public boolean isValid(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }

        if (s.length() % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();

    }
}
