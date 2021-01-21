/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
    
    let strLen = strs.length;
    if (strLen == 0) {
        return '';
    }
    let prefix = strs[0];

    if(strLen == 1){
        return prefix;  
    }
    for (let i = 1; i < strLen; i++){
        let str = strs[i];
        let j = 0;
        for (; j < prefix.length; j++){
            if (j > str.length - 1) // 뒤에 단어가 앞의 prefix보다 길이가짧으면
            {
                break;
            }
            if (str[j] != prefix[j]) {
                break;
            }
        }
        if (j == 0) {
            return '';
        }
        prefix=prefix.substring(0, j);
    }
    return prefix;
};
// longestCommonPrefix(["ab", "a"]);
// ["ab", "a"]