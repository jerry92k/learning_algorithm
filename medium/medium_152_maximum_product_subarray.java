class Solution {

    // Brute force
    public int maxProduct2(int[] nums) {

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

    // DP

    public int maxProduct3(int[] nums) {
        if (nums.length == 0)
            return 0;

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            int temp_max = Math.max(curr, Math.max(max_so_far * curr, min_so_far * curr));
            min_so_far = Math.min(curr, Math.min(max_so_far * curr, min_so_far * curr));

            max_so_far = temp_max;

            result = Math.max(max_so_far, result);
        }

        return result;
    }
    

    public int maxProduct(int[] nums) {
        if (nums.length == 0)
            return 0;

        int maxAccProd=nums[0];
        int minAccProd = maxAccProd;
        int maxProd = maxAccProd;

        for (int i = 1; i < nums.length; i++) {
            
            int currVal = nums[i];

            int tempMax= Math.max(maxAccProd * currVal, Math.max(minAccProd * currVal, currVal));
            minAccProd = Math.min(maxAccProd * currVal, Math.min(minAccProd * currVal, currVal));
            maxAccProd = tempMax;

            maxProd = Math.max(maxAccProd, maxProd);

        }
    }
}