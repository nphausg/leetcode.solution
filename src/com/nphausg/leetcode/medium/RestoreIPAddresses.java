package com.nphausg.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/restore-ip-addresses">93. Restore IP Addresses</a>
 */
public class RestoreIPAddresses {

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(String s, int start, List<String> path, List<String> result) {
        if (path.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }
        for (int len = 1; len <= 3 && start + len <= s.length(); len++) {
            String part = s.substring(start, start + len);
            if (isValid(part)) {
                path.add(part);
                backtrack(s, start + len, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    public static List<String> restoreIpAddressesBruteForce(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();

        for (int i = 1; i < 4 && i < n - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < n - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < n; k++) {
                    String a = s.substring(0, i);
                    String b = s.substring(i, j);
                    String c = s.substring(j, k);
                    String d = s.substring(k);

                    if (isValid(a) && isValid(b) && isValid(c) && isValid(d)) {
                        result.add(String.join(".", a, b, c, d));
                    }
                }
            }
        }

        return result;
    }

    private static boolean isValid(String ip) {
        if (ip.length() > 1 && ip.startsWith("0")) {
            return false;
        }
        if (ip.isBlank() || ip.length() > 3) {
            return false;
        }
        int val = Integer.parseInt(ip);
        return val >= 0 && val <= 255;
    }
}
