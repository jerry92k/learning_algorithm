import java.util.*;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can
 * be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * Note that the same word in the dictionary may be reused multiple times in the
 * segmentation.
 * 
 * Example 1: Input: s = "leetcode", wordDict = ["leet","code"] Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * 
 * Example 2: Input: s = "applepenapple", wordDict = ["apple","pen"] Output:
 * true Explanation: Return true because "applepenapple" can be segmented as
 * "apple pen apple". Note that you are allowed to reuse a dictionary word.
 * 
 * Example 3: Input: s = "catsandog", wordDict =
 * ["cats","dog","sand","and","cat"] Output: false
 */

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int wordLen = s.length();
        HashSet<String> wordDictionary = new HashSet<String>();
        Boolean[][] wordDictSubset = new Boolean[wordLen][wordLen]; // false로 초기화

        for (String word : wordDict) {
            wordDictionary.add(word);
        }

        for (int i = 0; i < wordLen; i++) {
            // for (int j = 0; j < i; j++) {
            // wordDictSubset[i][j] = false;
            // }

            for (int j = i; j < wordLen; j++) {
                if (wordDictionary.contains(s.substring(i, j + 1))) {
                    wordDictSubset[i][j] = true;

                    if (i > 0 && wordDictSubset[0][i - 1]) {
                        wordDictSubset[0][j] = true;
                    }
                } else {
                    wordDictSubset[i][j] = false;
                }
            }
        }
        if (wordDictSubset[0][wordLen - 1]) {
            return true;
        }
        return false;
    }
}
