/**
 * @param {string} s
 * @return {boolean}
 */


let validPalindrome = function(s) {
   
    let alpLastIdx = s.length - 1;

    let i = 0;
    for (; i <= (alpLastIdx / 2) >> 0; i++){

        if (s[i] != s[alpLastIdx - i]) {
            break;
        }
    }
    if (i > (alpLastIdx / 2) >> 0) {
        return true;
    }
    if (checkSubPalindrome(s.substring(i, alpLastIdx - i))||checkSubPalindrome(s.substring(i + 1, alpLastIdx - i + 1))) {
        return true;
    } // 뒤에 한자리를 빼봄
    // if (checkSubPalindrome(s.substring(i + 1, alpLastIdx - i + 1))) {
    //     return true;
    // } // 앞의 한자리를 빼봄
    //console.log(s);
    return false;
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
