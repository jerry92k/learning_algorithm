/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps


*/
// n-2 n-1 n
// ㅇ  ㅇ  ㅇ
// 

class Solution {
    public int climbStairs(int n) {

        // int[] numOfClimbWays=new int[n+1];
        int prePreWay = 1;
        int preWay = 1;

        int numOfWays = 0;
        for (int i = 2; i <= n; i++) {
            // numOfClimbWays[i]=numOfClimbWays[i-2]+numOfClimbWays[i-1];
            numOfWays = prePreWay + preWay;
            prePreWay = preWay;
            preWay = numOfWays;
        }
        // return numOfClimbWays[n];
        return numOfWays;
    }
}