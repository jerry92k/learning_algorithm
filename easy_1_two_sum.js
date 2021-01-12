/*
1. Two Sum

### 문제설명
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

### 예시
Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

### 제약사항 
Constraints:

2 <= nums.length <= 103
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.

*/

let twoSum = function(nums, target) {
    
    let i;
    let j;
    
    for(i=0; i<nums.length; i++){
      for(j=i+1; j<nums.length; j++){
          let sum=nums[i]+nums[j];
            if(sum==target){
                return [i,j];
            }
        }
    }
};

let twoSumWtHash = function(nums, target) {
    
    let i;
    let j;

    let map=new Map()
    
    for(i=0; i<nums.length; i++){
      needNum=target-nums[i];
      let getIdx=map.get(needNum);
      if(getIdx!=undefined){
          return [getIdx,i]
      }
      map.set(nums[i],i);
    }
};

// test case
let nums;
let target;

nums= [3,2,4];
target = 6;
console.log(twoSum(nums,target));
console.log(twoSumWtHash(nums,target));