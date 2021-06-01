import java.util.*;

class Test {
    public static void main(String args[]){
        Solution sol=new Solution();
        sol.solution(5,12);
    }
}

class Solution {
    public Solution() {
        
    }
    public int solution(int N, int number) {
        int maxNum = 8;
        List<Set<Integer>> totalCases = new ArrayList<Set<Integer>>();
        for (int i = 0; i < maxNum; i++) {
            Set<Integer> eachCases = new HashSet<Integer>();
            int continuousTime=i+1;
            int continuousVal=getMaxContinueNumber(N, continuousTime);
            if(continuousVal==number){
                return continuousTime;
            }
            eachCases.add(continuousVal);

            for (int j = 0; j < i; j++) {
                Set<Integer> frontSet = totalCases.get(j);
                Set<Integer> tailSet = totalCases.get(i - (j + 1));

                for(int frontVal:frontSet){
                    for (int tailVal : tailSet) {
                        int caseVal=frontVal+tailVal;
                        if(caseVal== number){
                            return continuousTime;
                        }
                        eachCases.add(caseVal);

                        caseVal=frontVal-tailVal;
                        if (caseVal == number) {
                            return continuousTime;
                        }
                        eachCases.add(caseVal);
                        
                        caseVal = frontVal * tailVal;
                        if (caseVal == number) {
                            return continuousTime;
                        }
                        
                        eachCases.add(caseVal);

                        if (frontVal == 0) {
                            caseVal = 0;
                        }
                        else if (tailVal == 0) {
                            continue;
                        }
                        else {
                            caseVal = frontVal / tailVal;
                            if (caseVal == number) {
                                return continuousTime;
                            }
                        }
                        eachCases.add(caseVal);
                        
                    }
                }
            }

            totalCases.add(i, eachCases);
        }
        
        return -1;
    }

    public int getMaxContinueNumber(int number, int continuNum) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < continuNum; i++) {
            //char numToChar=(char)(number+'0');
            char numToChar = Character.forDigit(number, 10);
            sb.append(numToChar);
        
        }
       
        return Integer.parseInt(sb.toString());
    }
}