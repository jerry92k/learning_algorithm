import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0 : 0
1 --> 1 : 1
2 --> 10 : 1
3 --> 11 : 2
4 --> 100 : 1
5 --> 101 : 2
6 --> 110 : 2
7 --> 111 : 3
8 --> 1000 : 1
9 --> 1001 : 2
10 -> 1010 : 2
11 -> 1011 : 3
12 -> 1100 : 2
13 -> 1101 : 3
14 -> 1110 : 3
15 -> 1111 : 4


*/

class Solution {
    public int[] countBits(int n) {
       // List<Integer> numOfOnes = new ArrayList<>();
       int[] numOfOnes = new int[n + 1];
       numOfOnes[0] = 0;
       if (n >= 1) {
           numOfOnes[1] = 1;
       }

       if (n <= 1) {
           return numOfOnes;
       }
       for (int i = 2; i <= n; i++) {
           int num = i;
           int count = 0;
           while (num > 1) {
               if ((num & 1) == 1) {
                   count++;
               }
               num = num / 2;
           }
           count++;
           numOfOnes[i] = count;
           //  numOfOnes.add(count);
       }
       return numOfOnes;
        //return numOfOnes.stream().mapToInt(Integer::intValue).toArray();
    }
}