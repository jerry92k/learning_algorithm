/**
 * @param {string} s
 * @return {boolean}
 */


let validPalindrome = function(s) {
   
    let alpLastIdx = s.length - 1;

    let i = 0;
    for (; i <= (alpLastIdx / 2) >> 0; i++){

        if (s[i] != s[alpLastIdx - i]) {
            // 뒤의 한자리를 뺀 케이스와 앞의 한자리를 뺀 케이스로 각각 탐색해봄
            if (checkSubPalindrome(s.substring(i, alpLastIdx - i)) || checkSubPalindrome(s.substring(i + 1, alpLastIdx - i + 1))) {
                
                // 둘중의 한 케이스에서 성립하는 경우가 있으면
                
              return true;
            } 
            return false;
        }
    }
    return true;
};

let checkSubPalindrome = function (subStr) {
    let strLastIdx = subStr.length-1;

    for (let j = 0; j <= (strLastIdx/2)>>0; j++){
        if (subStr[j] != subStr[strLastIdx - j]) {
            return false;
        }
    }
    return true;
};
