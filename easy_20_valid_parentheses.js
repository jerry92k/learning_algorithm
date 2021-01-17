let isValid = function(s) {
    let array=[];

    for(let val of s){
        if(val=='('||val=='{'||val=='['){ // 여는 괄호는 push
            array.push(val);
        }
        else{
            let popVal=array.pop(); // 닫는 괄호인 경우 pop 해서 유효성 검증

            if(val==')'){ 
                if(popVal!='('){
                    return false;
                }
            }
            else if(val==']'){
                if(popVal!='['){
                    return false;
                }
            }
            else if(val=='}'){
                if(popVal!='{'){
                    return false;
                }
            }
        } 
    }

    if(array.length>0){
        return false;
    }
    return true;
};

console.log(isValid("(]"));