let isValid = function(s) {
    let array=[];

    for(let val of s){
        if(val=='('||val=='{'||val=='['){
            array.push(val);
        }
        else{
            let popVal=array.pop();

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