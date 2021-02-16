/**
 * @param {string[]} logs
 * @return {string[]}
 */
let reorderLogFiles = function(logs) {
    
    for (let i = 0; i < logs.length - 1; i++){
        for (let j = 0; j < logs.length - 1 - i; j++){
            if (compareTo(logs[j], logs[j + 1])) {
                let temp = logs[j + 1];
                logs[j + 1] = logs[j];
                logs[j]=temp;
            }
        }
     //   console.log(logs);
    }
    return logs;
    
};

// true if switch arguments
let compareTo = function (str1, str2) {
    
    const regexp = new RegExp("[0-9]+"); //연속하는 하나 이상의 숫자 패턴

  //  console.log(`str1 ${str1} , str2: ${str2}`);
    let str1Spt = str1.split(' '); //구분자로 잘라서 array화
    let str2Spt = str2.split(' '); //구분자로 잘라서 array화

    for (let i = 1; i < str1Spt.length; i++) {
        
        let tempStr1 = str1Spt[i];

        if (str2Spt.length - 1 < i) {
            return true;
        }
        let tempStr2 = str2Spt[i];

       // console.log(`tempStr1 ${tempStr1} , tempStr2: ${tempStr2}`);
        if (regexp.test(tempStr1)&&regexp.test(tempStr2)) { // 앞: 숫자, 뒤:숫자 => 자리변경 안함
                return false;
        }else if(regexp.test(tempStr1)&&!regexp.test(tempStr2)){ // 앞: 숫자, 뒤:문자 => 자리변경
            // 뒤에는 숫자가 아니면 바꿔줘야함
            return true;
        }
        else if(!regexp.test(tempStr1)&&regexp.test(tempStr2)){ // 앞: 문자, 뒤: 숫자 => 자리변경안함
            
            return false;
        }
        // 둘 다 숫자가 아닌 경우
        if (tempStr1 > tempStr2) { // 앞의 문자열이 뒤의 문자열 보다 정렬순서가 크면 바꾸기
            return true;
        }
        else if (tempStr1 < tempStr2) {
            return false;
        }
        else { // 두 단어가 같을때, 마지막 자리인 경우에만 identifier 비교하면됨

            if (i == str1Spt.length - 1) {
                if (str1Spt[0] > str2Spt[0]) { //identifier 비교값이 뒤에것이 작은경우
                    return true;
                }
            }
        }
    }
    return false;

};

reorderLogFiles(
["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"])