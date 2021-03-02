import java.util.stream.IntStream;

class Solution {
    public int[] runningSum(int[] nums) {
      
        for(int i=1; i<nums.length; i++){
            nums[i]=nums[i-1]+nums[i];
        }
        return nums;
    }

    //stream- foreach가 일반 for문 보다 오버헤드는 크다
    public int[] runningSum2(int[] nums) {

        IntStream.range(1,nums.length)
                .forEach(i->{
                    nums[i]=nums[i-1]+nums[i];
                });
        return nums;
    }
}