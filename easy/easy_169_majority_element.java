/*
[방법1] 정렬후 순차탐색하며 maxCount의 원소 찾기
[방법2] 해쉬맵을 이용하여 각 원소별 횟수 카운팅
[방법3] Boyer-Moore Voting Algorithm (솔루션 참고)
        - majority element는 전체 배열의 2/n 개 이상을 차지함. 
*/

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}