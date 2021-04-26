class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int i = 0;
        int j = numbers.length - 1;

        int[] results = new int[2];
        while (i < j) {
            int tempSum = numbers[i] + numbers[j];
            if (tempSum > target) {
                j--;
            } else if (tempSum < target) {
                i++;
            } else { // 같으면
                results[0] = i + 1;
                results[1] = j + 1;
                break;
            }
        }
        return results;
    }
}