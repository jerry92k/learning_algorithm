/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
let moveZeroes = function(nums) {
    
    // let zeroCount=0;

    // for(let i=0; i<nums.length; i++){
    //     if(nums[i]==0){
    //         zeroCount++;
    //     }
    // }

    let arrIdx=0;
    for(let j=0; j<nums.length; j++){

        if(nums[j]!=0){
            if (nums[j]!=nums[arrIdx]){
                nums[arrIdx]=nums[j];
            }
            arrIdx++;
            // if(nums.length-arrIdx<=zeroCount){
            //     break;
            // }
        }
    }

    for(let k=arrIdx; k<nums.length; k++){
        nums[k]=0;
    }
    return nums;
};