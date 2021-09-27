

/*
# 423. Reconstruct Original Digits from English

### 문제정의
Given a string s containing an out-of-order English representation of digits 0-9, return the digits in ascending order.


### 예시
Example 1:
Input: s = "owoztneoer"
Output: "012"

Example 2:
Input: s = "fviefuro"
Output: "45"
 
### 제약사항
Constraints:

1 <= s.length <= 105
s[i] is one of the characters ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"].
s is guaranteed to be valid.

### 풀이
[전략]
- 숫자에 대한 영어단어를 정의해놓고
- 각 알파벳의 freq를 해쉬맵으로 관리하여
- 숫자단어를 순회하며 가능한 조합을 카운트해본다.
```java

0 -> zero
1 -> one
2 -> two
3 -> three
4 -> four
5 -> five
6 -> six
7 -> seven
8 -> eight
9 -> nine
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;


class Solution428 {

    public static void main(String[] args) {
        Solution428 solution = new Solution428();
        solution.originalDigits("zeroonetwothreefourfivesixseveneightnine");
    }

    public String originalDigits(String s) {
        final int maxSLen=100000;
        HashMap<String,Integer> numberStrs=getNumberStrs();
        HashMap<Character, Integer> alphabets = new HashMap<>();

        for (char ch : s.toCharArray()) {
            alphabets.compute(ch, (key, value) -> value == null ? 1 : value + 1);
        }
        System.out.println(alphabets);
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String,Integer> numberStrPair : numberStrs.entrySet()) {
            boolean hasNumber = true;
            int minMakeNum = maxSLen;
            char[] numberToMakeStr = numberStrPair.getKey().toCharArray();
            
            // 중복된 알파벳은 minMakeNum을 그 수만큼 나눠야함.
            Arrays.sort(numberToMakeStr);
            char preCh = numberToMakeStr[0];
            int count=1;
            for (int j = 0; j < numberToMakeStr.length; j++) {


                char ch = numberToMakeStr[j];

                if (alphabets.containsKey(ch)) {

                    if (j == 0) {
                        continue;
                    }
                    // 마지막이면
                    if (j == numberToMakeStr.length - 1) {

                        if (preCh == ch) {
                            minMakeNum = Math.min(minMakeNum, alphabets.get(preCh) / ++count);
                        }
                        else {
                            minMakeNum = Math.min(minMakeNum, alphabets.get(preCh) / count);
                            minMakeNum = Math.min(minMakeNum, alphabets.get(ch) / 1);
                        }
                        
                    } else {
                        if (preCh == ch) {
                            count++;
                        } else {
                            minMakeNum = Math.min(minMakeNum, alphabets.get(preCh) / count);
                            count = 1;
                            preCh = ch;
                        }
                    }            
                } else {
                    hasNumber = false;
                    break;
                }
            }
            
            if (!hasNumber) {
                continue;
            }

            int numberVal = numberStrPair.getValue();
            
            String str = String.valueOf(numberVal);
            for (int i = 0; i < minMakeNum; i++) {
                sb.append(str);
            }

            System.out.println("numberToMakeStr : " + String.valueOf(numberToMakeStr));
            System.out.println("minMakeNum : " + minMakeNum);
            for (char ch : numberToMakeStr) {
                System.out.println("ch : "+ch);
                int freq = alphabets.get(ch);
                System.out.println("freq : " + freq);

                freq -= minMakeNum;
                if (freq == 0) {
                    alphabets.remove(ch);
                } else {
                    alphabets.put(ch, freq);
                }
            }

        }

        char[] resultArr = sb.toString().toCharArray();
        Arrays.sort(resultArr);
        return String.valueOf(resultArr);
    }

    public HashMap<String,Integer> getNumberStrs() {
        HashMap<String,Integer>  numberStrs= new HashMap<>();
        numberStrs.put("zero",0);
        numberStrs.put("one",1);
        numberStrs.put("two",2);
        numberStrs.put("three",3);
        numberStrs.put("four",4);
        numberStrs.put("five",5);
        numberStrs.put("six",6);
        numberStrs.put("seven",7);
        numberStrs.put("eight",8);
        numberStrs.put("nine",9);
        return numberStrs;
    }
}
// ```