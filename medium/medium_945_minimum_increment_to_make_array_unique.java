class Solution {
    public int minIncrementForUnique(int[] nums) {

        /*
         * [전략] 1. 각 원소 값의 frequency를 계산하여, 값을 index로 frequency 값을 저장하는 배열을 생성하여 2. 원소별
         * 하나만 남기고 나머지 freqency는 1씩 더하여 다음 index의 값으로 중첩하며 배열을 순환. => 각 단계에서 나머지
         * frequency들 만큼 increase count에 산정함
         */

        if (nums.length < 2) {
            return 0;
        }
        int maxVal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxVal = Math.max(maxVal, nums[i]);
        }

        int[] freqNum = new int[maxVal + 2];

        for (int i = 0; i < nums.length; i++) {
            freqNum[nums[i]]++;
        }

        int increaseCount = 0;
        for (int i = 0; i <= maxVal; i++) {
            if (freqNum[i] > 1) {
                int increaseVal = freqNum[i] - 1;
                increaseCount += increaseVal;
                freqNum[i + 1] += increaseVal;
            }
        }
        for (int i = 1; i < freqNum[maxVal + 1]; i++) {
            increaseCount += i;
        }
        return increaseCount;
    }
}