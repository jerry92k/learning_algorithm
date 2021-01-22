/**
 * @param {string} s
 * @return {boolean}
 */
let isPalindrome = function(s) {
    s = s.toLowerCase(); // 대문자 -> 소문자
    const regexp = new RegExp(/[^a-z0-9]/g); //알파벳이 아니면. g: 모든 매칭되는 포인트에 적용
    
    s=s.replace(regexp, '');

    let alpLastIdx = s.length-1;

    for (let i = 0; i <= (alpLastIdx / 2) >> 0; i++){

        if (s[i] != s[alpLastIdx - i]) {
            return false;
        }
    }
    //console.log(s);
    return true;
};

isPalindrome("A man, a plan, a canal: Panama");