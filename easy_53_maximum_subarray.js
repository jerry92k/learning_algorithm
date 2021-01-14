

var maxSubArray = function(nums) {
    
    let maxSum=nums[0];
    let subSum=maxSum;
    for(let i=1; i<nums.length; i++){

        if(subSum>0){
            subSum=subSum+nums[i];
        }
        else{
            subSum=nums[i];
        }
        
       if(subSum>maxSum){
           maxSum=subSum;
       }
    }
    return maxSum;
};