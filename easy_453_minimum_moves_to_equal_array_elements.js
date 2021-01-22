/**
 * @param {number[]} nums
 * @return {number}
 */
let minMoves = function (nums) {
    
    let minimum = nums[0];
    
    let moves = 0;
    let lastIdx = nums.length - 1;

    for (let i = 1; i <= lastIdx; i++){
        if (nums[i] < minimum) {
            minimum = nums[i];
        }
    }
    for (let i = 0; i <= lastIdx; i++){
        moves = moves + nums[i] - minimum;
    }
    return moves;
};