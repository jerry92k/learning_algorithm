import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        if (sArr.length != t.length()) {
            return false;
        }
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] != tArr[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagramByHash(String s, String t) {

        // char[] sArr = s.toCharArray();
        // char[] tArr = t.toCharArray();

        if (s.length != t.length()) {
            return false;
        }

        int[] counter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length; i++) {
            int countIdx = t.charAt(i) - 'a';
            counter[countIdx]--;

            if (counter[countIdx] < 0) {
                return false;
            }
        }
        return true;
    }
}