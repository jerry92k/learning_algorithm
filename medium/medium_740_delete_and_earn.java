
/*
Given an array nums of integers, you can perform operations on the array.

In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.

You start with 0 points. Return the maximum number of points you can earn by applying such operations.

 

Example 1:

Input: nums = [3,4,2]
Output: 6
Explanation: Delete 4 to earn 4 points, consequently 3 is also deleted.
Then, delete 2 to earn 2 points.
6 total points are earned.

*/
import java.util.*;

class Solution {
    public int deleteAndEarn(int[] nums) {

        Arrays.sort(nums);

        HashMap<Integer, Integer> numHashMap = new HashMap<Integer, Integer>();

        int repCount = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int pointVal = nums[i];
            if (i > 0 && pointVal == nums[i - 1]) {
                repCount++;
            } else {
                numHashMap.put(pointVal, pointVal * repCount);
                repCount = 1;
            }
        }

        int mappingSize = numHashMap.size();

        int[] dp = new int[mappingSize];

    }

}
