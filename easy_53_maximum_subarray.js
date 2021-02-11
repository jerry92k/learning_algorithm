var maxSubArray = function(nums) {
    
    let maxSum=nums[0];
    let subSum=maxSum;
    for(let i=1; i<nums.length; i++){

        if(subSum>0){ //이전까지의 subSum이 양수면 continuously 
            subSum=subSum+nums[i];
        }
        else{ //이전까지의 subSum이 음수면 새로운 subSum 산정
            subSum=nums[i];
        }
        
       if(subSum>maxSum){
           maxSum=subSum;
       }
    }
    return maxSum;
};