class Solution {

    public int maxProduct(int[] nums) {

        int maxProd = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int preProd = 1;
            for (int j = i; j < nums.length; j++) {
                if (i == j) {
                    preProd = nums[j];
                } else {
                    preProd = preProd * nums[j];
                }
                maxProd = Math.max(maxProd, preProd);
            }
        }
        return maxProd;
    }
}