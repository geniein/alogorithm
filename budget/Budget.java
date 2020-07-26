package budget;

import java.util.Arrays;

public class Budget {
    public int solution(int[] budgets, int M) {
        int answer = 0;
        int sum = 0;
        for(int i : budgets){
            sum += i;
        }
        if(sum < M)
        {
            Arrays.sort(budgets);
            answer = budgets[budgets.length-1];
            System.out.println(answer);
            return answer;
        }

        dichotomy(budgets,M,0,M);
        answer = result;
        System.out.println(answer);
        return answer;
    }
    int result =0;
    void dichotomy(int[] budgets, int M, int min, int max){
        int[] newResult = new int[budgets.length];        
        int nextM = (min + max)/2;
        // System.out.println("min :"+min +" max : "+max);
        // System.out.println(nextM);
        int sum = 0;
        for(int i =0; i<budgets.length; i++){
            if(budgets[i] > nextM){
                newResult[i] = nextM;
            }else {
                newResult[i] = budgets[i];
            }
        }
        for(int i :  newResult){
            sum += i;
        }        
        if(sum>M){
            max = nextM;
        }else {
            if( min == nextM){                
                result = nextM;
                return;
            }       
            min = nextM;            
        }
       dichotomy(budgets, M, min, max);       
    }

    public static void main(String[] args) {
        int[] budgets = {120, 110, 140, 150};
        int M = 600;
        new Budget().solution(budgets, M);
    }
}