import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        Arrays.sort(nums);

        int preNum = nums[0];
        hashMap.put(preNum, 0);
        for (int i = 1; i < nums.length; i++) {
            if (preNum != nums[i]) {
                preNum = nums[i];
                hashMap.put(nums[i], i);
            }
        }

        int i = -1;
        int j = nums.length - 1;
        List<List<Integer>> sumList = new ArrayList<List<Integer>>();
        int temp = 0;

        while (true) {

            i++;
            if (i >= j) {
                break;
            }
            System.out.println("here");
            System.out.println("i: " + i + " j:" + j + " nums[i]:" + nums[i] + " nums[j]:" + nums[j]);
            if (i > 0 && nums[i] != nums[i - 1]) { // 이전값이랑 같으면 계산할 필요 없음
                temp = 0 - (nums[i] + nums[j]);
                if (hashMap.containsKey(temp)) {
                    sumList.add(Arrays.asList(temp, nums[i], nums[j]));
                }
            }

            j--;
            if (i >= j) {
                break;
            }

            System.out.println("here2");
            System.out.println("i: " + i + " j:" + j + " nums[i]:" + nums[i] + " nums[j]:" + nums[j]);
            if (nums[j] != nums[j + 1]) {
                temp = 0 - (nums[i] + nums[j]);
                if (hashMap.containsKey(temp)) {
                    sumList.add(Arrays.asList(temp, nums[i], nums[j]));
                }
            }
        }
        return sumList;
    }
}