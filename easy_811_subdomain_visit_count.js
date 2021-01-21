/**
 * @param {string[]} cpdomains
 * @return {string[]}
 */
var subdomainVisits = function (cpdomains) {
    
    let map = new Map();
    for (let cpdomain of cpdomains) {
        let starIdx = 0;
        let splitIdx = 0;
        let count = 0;
        // 제일 앞의 숫자 구분을 위한 구분값
        splitIdx = cpdomain.indexOf(' ');
        //substring(start,end) =>  [start:end-1]
        count = cpdomain.substring(starIdx, splitIdx);

        starIdx = splitIdx + 1;
        // endIdx = cpdomain.lastIndexOf('.', starIdx); 
        for (; splitIdx != -1;) {

            // substring의 종료 인덱스가 음수인 경우, 암시적을 마지막 인덱스 할당
            cpdomain = cpdomain.substring(starIdx)
            starIdx = 0;
            
            let preCount = map.get(cpdomain);
            if (preCount == undefined) { // map.get 에서 요소를 찾기 못하는 경우 undefined 반환.
                preCount = 0;
            }
            map.set(cpdomain, Number(count) + preCount);
            splitIdx = cpdomain.indexOf('.', starIdx);

            starIdx = splitIdx + 1;
        }
    }

    let res = [];
    for (let pair of map) {
      //  console.log(pair[1] + ' ' + pair[0]); // pair[0] : key, pair[1]: value
        res.push(pair[1] + ' ' + pair[0]);
    }
    return res;
};
subdomainVisits(["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]);

/*
 - null 과 undefined 차이 
 - 둘다 값이 없음을 나타내는 것은 같음.
 - 동등연산자(==)로는 두개 비교시 true 리턴.
 - 형타입까지 비교하는 (===) 연산자로는 false 리턴.

 */