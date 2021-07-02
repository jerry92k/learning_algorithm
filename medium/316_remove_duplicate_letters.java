/*
Given a string s,
remove duplicate letters 
so that every letter appears once and only once. 

You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"


*/
/*
[전략]
1. 해쉬맵에 각 알파벳별 갯수를 저장하여
2. 앞에서부터, 2개 이상의 알파벳인경우, 다음 알파벳보다 큰 알파벳이면 지운다. 

"bcabc"
a : 1
b : 2
c : 2

*/

import java.util.*;

class Solution {
    public String removeDuplicateLetters2(String s) {
        HashMap<Character, Integer> alphaHash = new HashMap<>();
        Set<Character> remainAlphas = new HashSet<Character>();

        // 알파벳별로 반복횟수 보관
        for (int i = 0; i < s.length(); i++) {
            // alphaHash.computeIfAbsent(s.charAt(i), key -> true);
            alphaHash.compute(s.charAt(i), (key, value) -> value == null ? 1 : value + 1);
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i == s.length() - 1) {
                if (alphaHash.get(ch) <= 1) {
                    sb.append(ch);
                }
                break;
            }
            char nextCh = s.charAt(i + 1);
            if (alphaHash.get(ch) > 1) {
                if (!remainAlphas.contains(ch)) { // 한 개 이상의 알파벳일경우, 그리고 알파벳을 아직 남기지 않은 경우)
                    if (ch < nextCh) {
                        remainAlphas.add(ch);
                        sb.append(ch);
                    } else {
                        alphaHash.compute(ch, (key, value) -> value - 1);
                    }
                } else {
                    alphaHash.compute(ch, (key, value) -> value - 1);
                }
            } else {
                sb.append(ch);
            }

        }
        return sb.toString();

    }

    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> alphaHash = new HashMap<>();
        Set<Character> remainAlphas = new HashSet<Character>();

        // 알파벳별로 반복횟수 보관
        for (int i = 0; i < s.length(); i++) {
            // alphaHash.computeIfAbsent(s.charAt(i), key -> true);
            alphaHash.compute(s.charAt(i), (key, value) -> value == null ? 1 : value + 1);
        }
        StringBuilder sb = new StringBuilder();

        int i = 0;
        // for (int i = 0; i < s.length(); i++) {
        while (i < s.length()) {
            char ch = s.charAt(i);

            if (i == s.length() - 1) {
                if (alphaHash.get(ch) <= 1) {
                    sb.append(ch);
                }
                break;
            }
            char nextCh = s.charAt(i + 1);
            if (alphaHash.get(ch) > 1) {
                if (!remainAlphas.contains(ch)) { // 한 개 이상의 알파벳일경우, 그리고 알파벳을 아직 남기지 않은 경우)
                    if (ch < nextCh) {
                        int nextIdx = i + 1;
                        while (nextIdx < s.length() && alphaHash.get(s.charAt(nextIdx)) > 1) {

                        }
                        remainAlphas.add(ch);
                        sb.append(ch);
                    } else {
                        alphaHash.compute(ch, (key, value) -> value - 1);
                    }
                } else {
                    alphaHash.compute(ch, (key, value) -> value - 1);
                }
            } else {
                sb.append(ch);
            }
            i++;

        }
        return sb.toString();

    }
}