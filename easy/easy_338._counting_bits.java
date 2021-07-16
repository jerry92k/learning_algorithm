import java.util.ArrayList;
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
        List<List<Integer>> numOfOnes=new ArrayList<>();
        List<Integer> initList=new ArrayList<>();
        initList.add(0);

        numOfOnes.add(initList);
        for(int i=0; i<n; i++){
            List<Integer> nextList=new ArrayList<>();
            List<Integer> preList=numOfOnes.get(i);

            for(int num : )

        }
    }
}