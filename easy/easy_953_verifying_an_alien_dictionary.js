
let isAlienSorted = function(words, order) {
    let map = new Map();

    // 알파벳을 key, 순서를 value로 하여 순서 비교에 사용
    for(let i=0; i<order.length; i++){
        map.set(order[i],i);
    }

    // 앞에서 부터 두단어씩 비교
    for(let j=0; j<words.length-1; j++){
        let preWord=words[j];
        let nextWord=words[j+1];
        
        let lastIdxofnw=nextWord.length-1;

        for(k=0; k<preWord.length; k++){
            
            // 앞자리까지 순서가 같은데 앞단어에는 추가문자가 있을경우는 잘못된 정렬이므로 return false
            if(k>lastIdxofnw)
            {
                return false;
            }

            // 순서를 수치화한 값을 비교하여, 
            if(map.get(preWord[k])<map.get(nextWord[k])){ //앞단어의 문자 순서가 우선시되면 다음 단어 간 비교로 넘어감
               break;
            }
            else if(map.get(preWord[k])>map.get(nextWord[k])){ //뒤 단어의 문자의 순서가 우선시되는 거면 return false;
                return false;
            }
            //같은번째 자리에 같은 문자면 이후도 봐야하므로 for문 계속
        }
    }

    //검증을 다 통과했으면 return true;

    return true;
};

console.log(isAlienSorted(["fxasxpc","dfbdrifhp","nwzgs","cmwqriv","ebulyfyve","miracx","sxckdwzv","dtijzluhts","wwbmnge","qmjwymmyox"],'zkgwaverfimqxbnctdplsjyohu'));
